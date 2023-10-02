package elite.dangerous;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.atteo.classindex.ClassIndex;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import elite.dangerous.journal.Event;
import elite.dangerous.utils.ReflectionHelper;

public class EliteAPI
{
    private static ObjectMapper                        jsonMapper;
    private static Map<String, Class<? extends Event>> eventClassMap;

    static ObjectMapper getJsonMapper()
    {
        if (jsonMapper == null)
        {
            synchronized (EliteAPI.class)
            {
                if (jsonMapper == null)
                {
                    //!f
                    jsonMapper = new JsonMapper()
                        .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
                        .disable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)
                        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                        .setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
                    //@f
                }
            }
        }
        return jsonMapper;
    }

    static Map<String, Class<? extends Event>> eventClassMap()
    {
        if (eventClassMap == null)
        {
            synchronized (EliteAPI.class)
            {
                if (eventClassMap == null)
                {
                    //!f
                    eventClassMap = new LinkedHashMap<>();
                    var set = StreamSupport.stream(ClassIndex.getSubclasses(Event.class).spliterator(), false).collect(Collectors.toSet());
                    if (set.isEmpty())
                    {
                        eventClassMap = ReflectionHelper.mapClassNamesToObjects("elite.dangerous.journal.events", Event.class);
                    } else {
                        set.forEach(e ->
                        {
                            eventClassMap.put(e.getSimpleName(), e);
                        });
                    }
                    //@f
                }
            }
        }
        return eventClassMap;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Event> T parse(String json)
    {
        Objects.requireNonNull(json, "cannot parse from null string");
        try
        {
            var jsonNode = constructJsonNode(InformalFieldNameHandler.parse(json));
            var eventClass = getEventClass(jsonNode);
            
            return (T) fromJson(jsonNode.toString(), eventClass);

        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private static JsonNode constructJsonNode(String json) throws IOException
    {
        Objects.requireNonNull(json, "cannot constructJsonNode from null string");
        JsonFactory factory = getJsonMapper().getFactory();
        JsonParser  parser  = factory.createParser(json);
        return getJsonMapper().readTree(parser);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Event> Class<T> getEventClass(JsonNode node)
    {
        Objects.requireNonNull(node, "cannot getClassEvent from null JsonNode");
        var subtype = SubtypeHandler.getSubtypeIfPresent(node);
        if(subtype.isPresent())
        {
            return (Class<T>) subtype.get();
        }
        
        return (Class<T>) eventClassMap().get(node.get("event").asText());
    }

    private static <T> T fromJson(String json, Class<T> clazz) throws IOException
    {
        return (T) getJsonMapper().readValue(json, clazz);
    }
}
