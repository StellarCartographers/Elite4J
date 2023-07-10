package elite.dangerous.utils.deserializer;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import elite.dangerous.EventGroup;
import elite.dangerous.base.Event;

public class EventDeserializer implements JsonDeserializer<Event>
{

    String                              eventTypeElementName;
    Map<String, Class<? extends Event>> eventTypeRegistry;

    public EventDeserializer(String eventTypeElementName, EventGroup group)
    {
        this.eventTypeElementName = eventTypeElementName;
        this.eventTypeRegistry = new HashMap<>();
        for (Class<? extends Event> eventGroup : group.getClassSet())
        {
            this.registerEventType(eventGroup);
        }
    }

    public void registerEventType(Class<? extends Event> eventType)
    {
        this.eventTypeRegistry.put(eventType.getSimpleName(), eventType);
    }

    @Override
    public Event deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        Event event = null;

        JsonObject             jsonEvent        = json.getAsJsonObject();
        JsonElement            eventTypeElement = jsonEvent.get(this.eventTypeElementName);
        String                 type             = eventTypeElement.getAsString();
        Class<? extends Event> eventClass       = this.eventTypeRegistry.get(type);
        if (eventClass != null)
        {
            event = context.deserialize(json, eventClass);
        }

        return event;
    }
}
