package elite.dangerous;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.atteo.classindex.ClassIndex;
import org.tinylog.Logger;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import elite.dangerous.capi.base.CAPIData;
import elite.dangerous.journal.base.Event;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

public class Elite4J
{

    //!fr
    private static final ObjectMapper OUTPUT_MAPPER = new ObjectMapper()
                    .setSerializationInclusion(Include.NON_NULL)
                    .setVisibility(PropertyAccessor.FIELD, Visibility.ANY)
                    .enable(SerializationFeature.INDENT_OUTPUT)
                    .disable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)
                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    .setDefaultPrettyPrinter(new DefaultPrettyPrinter().withArrayIndenter(new DefaultIndenter("    ", DefaultIndenter.SYS_LF)));
    //@fr

    public static String ObjToString(Object object)
    {
        try {
            if (object instanceof Optional) {
                if (((Optional<?>) object).isPresent())
                    return OUTPUT_MAPPER.writeValueAsString(((Optional<?>) object).get());
                else
                    return "not present";
            }
            return OUTPUT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            Logger.error(e);
            e.printStackTrace();
            return "Error";
        }
    }
    
    public static final class Journal
    {
        private volatile static Journal instance;

        private JournalEvents events;

        private static Journal get()
        {
            if (instance == null) {
                synchronized (Journal.class) {
                    if (instance == null) {
                        instance = new Journal();
                    }
                }
            }
            return instance;
        }

        private Journal()
        {
            var set = StreamSupport.stream(ClassIndex.getSubclasses(Event.class).spliterator(), false).collect(Collectors.toSet());
            if (set.isEmpty()) {
                events = JournalEvents.mapClassNamesToObjects("elite.dangerous.journal.events", Event.class);
            } else {
                events = new JournalEvents();
                set.forEach(e -> {
                    events.put(e.getSimpleName(), e);
                });
            }
        }

        public static JournalEvents getJournalEvents()
        {
            return Journal.get().events;
        }

        public static <T extends Event> Optional<Event> parse(String json)
        {
            Objects.requireNonNull(json, "cannot parse from null string");
            var instance = Journal.get();
            try {
                var jsonNode = instance.constructJsonNode(InformalFieldNameHandler.parse(json));
                var eventClass = instance.getEventClass(jsonNode);
                return Optional.ofNullable(instance.fromJson(jsonNode.toString(), eventClass));
            } catch (IOException e) {
                Logger.error(e);
                return Optional.empty();
            }
        }

        private JsonNode constructJsonNode(String json) throws IOException
        {
            Objects.requireNonNull(json, "cannot constructJsonNode from null string");
            JsonFactory factory = Mapper.get().getFactory();
            JsonParser parser = factory.createParser(json);
            return Mapper.get().readTree(parser);
        }

        @SuppressWarnings("unchecked")
        private <T extends Event> Class<T> getEventClass(JsonNode node)
        {
            Objects.requireNonNull(node, "cannot getClassEvent from null JsonNode");
            var subtype = SubtypeHandler.getSubtypeIfPresent(node);
            if (subtype.isPresent()) {
                return (Class<T>) subtype.get();
            }

            return (Class<T>) events.get(node.get("event").asText());
        }

        private <T extends Event> T fromJson(String json, Class<T> type)
        {
            try {
                return Mapper.get().readValue(json, type);
            } catch (JsonProcessingException e) {
                Logger.error(e);
                return null;
            }
        }

        static final class Mapper extends JsonMapper
        {
            private static final long serialVersionUID = 5727134984977613956L;

            private volatile static Journal.Mapper instance;

            static Journal.Mapper get()
            {
                if (instance == null) {
                    synchronized (Journal.Mapper.class) {
                        if (instance == null) {
                            instance = new Journal.Mapper();
                        }
                    }
                }
                return instance;
            }

            private Mapper()
            {
                this.setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE);
                this.disable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);
                this.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                this.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            }
        }
    }
    
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class CAPI
    {
        private volatile static CAPI instance;
        private volatile CAPI.Mapper mapper;

        private static CAPI get()
        {
            if (instance == null) {
                synchronized (CAPI.class) {
                    if (instance == null) {
                        instance = new CAPI(Mapper.get());
                    }
                }
            }
            return instance;
        }

        public static <T extends CAPIData> Optional<T> parse(String json, Class<T> type)
        {
            try {
                return Optional.ofNullable(get().mapper.readValue(json, type));
            } catch (JsonProcessingException e) {
                Logger.error(e);
                return Optional.empty();
            }
        }
        
        public static <T extends CAPIData> Optional<T> parse(File file, Class<T> type)
        {
            try {
                return Optional.ofNullable(get().mapper.readValue(file, type));
            } catch (IOException e) {
                Logger.error(e);
                e.printStackTrace();
                return Optional.empty();
            }
        }
        
        static final class Mapper extends JsonMapper
        {
            private static final long serialVersionUID = 5727134984977613956L;

            private volatile static CAPI.Mapper instance;

            static CAPI.Mapper get()
            {
                if (instance == null) {
                    synchronized (CAPI.Mapper.class) {
                        if (instance == null) {
                            instance = new CAPI.Mapper();
                        }
                    }
                }
                return instance;
            }

            private Mapper()
            {
                this.disable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);
                this.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                this.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            }
        }
    }
}
