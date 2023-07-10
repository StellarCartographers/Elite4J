package elite.dangerous;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.common.eventbus.EventBus;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import elite.dangerous.base.Bounty;
import elite.dangerous.base.Event;
import elite.dangerous.capi.meta.Modules;
import elite.dangerous.capi.meta.Name;
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

    private static Gson GSON;
    static EventBus EVENT_BUS;
    private static final Map<Class<? extends Event>, Trigger> eventList = new HashMap<>();
    
    static
    {
        EliteAPI.eventList.putAll(EventGroup.getMap());
        EliteAPI.EVENT_BUS = new EventBus();
        //@noformat
        EliteAPI.GSON = new GsonBuilder()
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

    public static void registerEventListener(Object obj)
    {
        EliteAPI.EVENT_BUS.register(obj);
    }

    public static <T extends Event> T getEvent(String json, Class<? extends T> type)
    {
        T event;
        try {
            var jsonEvent = JsonParser.parseString(new String(json.getBytes(StandardCharsets.UTF_8))).getAsJsonObject();
            event = EliteAPI.GSON.fromJson(jsonEvent, type);
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
            triggerEventBus(event);
        }
    }

    protected static synchronized <T extends Event> void triggerEventBus(T event)
    {
        if (EliteAPI.eventList.containsKey(event.getClass()))
        {
            EVENT_BUS.post(new EventTiggered(event.getClass().getSimpleName().replace("Event", "")));
            EliteAPI.eventList.get(event.getClass()).onTriggered(event);
        }
    }

    public static void triggerStatusEventIfNeeded()
    {
        var statusEvent = Status.loadFromFile();
        if (statusEvent != null)
        {
            triggerEventBus(statusEvent);
        }
    }

    protected static synchronized Event parseEvent(JsonObject jsonEvent)
    {
        Event event = null;
        try
        {
            event = EliteAPI.GSON.fromJson(jsonEvent, Event.class);
        } catch (JsonSyntaxException ignored)
        {
            ignored.printStackTrace();
        }

        return event;
    }
}
