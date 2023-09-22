package elite.dangerous;

import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.tinylog.Logger;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import elite.dangerous.base.Bounty;
import elite.dangerous.base.Event;
import elite.dangerous.capi.modal.fleetcarrier.Modules;
import elite.dangerous.capi.modal.fleetcarrier.Name;
import elite.dangerous.events.EventTiggered;
import elite.dangerous.events.combat.Died;
import elite.dangerous.events.combat.ShipTargeted;
import elite.dangerous.events.exploration.Scan;
import elite.dangerous.events.other.Status;
import elite.dangerous.models.scan.Parent;
import elite.dangerous.utils.IngoreExclusion;
import elite.dangerous.utils.deserializer.BountyEventDeserializer;
import elite.dangerous.utils.deserializer.DiedEventDeserializer;
import elite.dangerous.utils.deserializer.EventDeserializer;
import elite.dangerous.utils.deserializer.FleetCarrierNameAdapter;
import elite.dangerous.utils.deserializer.ModulesDeserializer;
import elite.dangerous.utils.deserializer.ParentDeserializer;
import elite.dangerous.utils.deserializer.ScanEventDeserializer;
import elite.dangerous.utils.deserializer.ShipTargetedEventDeserializer;
import elite.dangerous.utils.deserializer.UTCDateDeserializer;

public class EliteAPI
{
    private static final EliteEventBus eliteEventBus = EliteEventBus.nonOperational();
    private static Gson gson;
    private static final Map<Class<? extends Event>, Trigger> eventList = new HashMap<>();
    
    static
    {
        EliteAPI.eventList.putAll(EventGroup.getMap());
        //@noformat
        EliteAPI.gson = new GsonBuilder()
            .setPrettyPrinting()
            .setExclusionStrategies(new IngoreExclusion())
            .setFieldNamingStrategy(f -> FieldNamingPolicy.UPPER_CAMEL_CASE.translateName(f).replaceFirst("Localised$", "_Localised"))
            .registerTypeAdapter(Event.class, new EventDeserializer("event", EventGroup.ALL))
            .registerTypeAdapter(Died.class, new DiedEventDeserializer())
            .registerTypeAdapter(Parent.class, new ParentDeserializer())
            .registerTypeAdapter(Bounty.class, new BountyEventDeserializer())
            .registerTypeAdapter(Scan.class, new ScanEventDeserializer())
            .registerTypeAdapter(ShipTargeted.class, new ShipTargetedEventDeserializer())
            .registerTypeAdapter(Modules.class, new ModulesDeserializer())
            .registerTypeAdapter(Name.class, new FleetCarrierNameAdapter())
            .registerTypeAdapter(Date.class, new UTCDateDeserializer())
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            .create();
      //@format
    }

    public static void enableEventBus()
    {
        if(eliteEventBus.alreadyActive())
        {
            Logger.info("EliteEventBus has already been activated");
            return;
        }
    }

    public static <T extends Event> T getEvent(String json, Class<? extends T> type)
    {
        T event;
        try {
            var jsonEvent = JsonParser.parseString(new String(json.getBytes(StandardCharsets.UTF_8))).getAsJsonObject();
            event = EliteAPI.gson.fromJson(jsonEvent, type);
        } catch (JsonSyntaxException e) {
            event = null;
        }
        return event;
    }
    
    public static synchronized void parseExternalEvent(String eventString)
    {
        var jsonEvent = JsonParser.parseString(new String(eventString.getBytes(StandardCharsets.UTF_8))).getAsJsonObject();

        var event = parseEvent(jsonEvent);
        if (event != null)
        {
            triggerEvent(event);
        }
    }

    protected static synchronized <T extends Event> void triggerEvent(T event)
    {
        if (EliteAPI.eventList.containsKey(event.getClass()))
        {
            eliteEventBus.post(new EventTiggered(event.getClass().getSimpleName().replace("Event", "")));
            EliteAPI.eventList.get(event.getClass()).onTriggered(eliteEventBus, event);
        }
    }

    public static void triggerStatusEventIfNeeded()
    {
        var statusEvent = Status.loadFromFile();
        if (statusEvent != null)
        {
            triggerEvent(statusEvent);
        }
    }

    protected static synchronized Event parseEvent(JsonObject jsonEvent)
    {
        Event event = null;
        try
        {
            event = EliteAPI.gson.fromJson(jsonEvent, Event.class);
        } catch (JsonSyntaxException ignored)
        {
            ignored.printStackTrace();
        }

        return event;
    }
    
    public static String toJson(Object src)
    {
        return EliteAPI.gson.toJson(src);
    }
    
    public static String toJson(Reader src, Type typeOfSrc)
    {
        return EliteAPI.gson.toJson(src, typeOfSrc);
    }
    
    public static String toJson(Object src, Type typeOfSrc)
    {
        return EliteAPI.gson.toJson(src, typeOfSrc);
    }
    
    public static <T> T fromJson(Reader reader, Type classOfT)
    {
        return EliteAPI.gson.fromJson(reader, classOfT);
    }
    
    public static <T> T fromJson(Reader reader, Class<T> classOfT)
    {
        return EliteAPI.gson.fromJson(reader, classOfT);
    }
    
    public static <T> T fromJson(JsonElement json, Type classOfT)
    {
        return EliteAPI.gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(JsonElement json, Class<T> classOfT)
    {
        return EliteAPI.gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type classOfT)
    {
        return EliteAPI.gson.fromJson(json, classOfT);
    }
    
    public static <T> T fromJson(String json, Class<T> classOfT)
    {
        return EliteAPI.gson.fromJson(json, classOfT);
    }
}
