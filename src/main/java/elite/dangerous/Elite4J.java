package elite.dangerous;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.atteo.classindex.ClassIndex;
import org.jetbrains.annotations.Nullable;
import org.tinylog.Logger;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import elite.dangerous.capi.CAPIData;
import elite.dangerous.journal.base.Event;
import elite.dangerous.util.JsonValueOption;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Elite4J
{
    static final PrettyPrinter PRINTER = new JsonOutputFormatter();

    public static String ObjToString(Object obj)
    {
        var pkg = obj.getClass().getPackageName();
        if (pkg.startsWith("elite.dangerous.capi"))
        {
            return CAPI.get().mapper.asString(obj);
        } else
        {
            return Journal.get().mapper.asString(obj);
        }
    }

    public static final class Journal
    {
        private volatile static Journal instance;

        private JournalEvents           events;
        private Journal.Mapper          mapper;

        private static Journal get()
        {
            if (instance == null)
            {
                synchronized (Journal.class)
                {
                    if (instance == null)
                    {
                        instance = new Journal();
                    }
                }
            }
            return instance;
        }

        private Journal()
        {
            var set = StreamSupport.stream(ClassIndex.getSubclasses(Event.class).spliterator(), false).collect(Collectors.toSet());
            if (set.isEmpty())
            {
                this.events = JournalEvents.mapClassNamesToObjects("elite.dangerous.journal.events", Event.class);
            } else
            {
                this.events = new JournalEvents();
                set.forEach(e ->
                {
                    this.events.put(e.getSimpleName(), e);
                });
            }
            this.mapper = new Journal.Mapper();
        }

        public static JournalEvents getJournalEvents()
        {
            return Journal.get().events;
        }
        
        public static <T extends Event> Optional<T> parse(String json, Class<T> type)
        {
            return Optional.ofNullable(get().fromJson(json, type));
        }

        public static <T extends Event> Optional<Event> parse(String json)
        {
            Objects.requireNonNull(json, "cannot parse from null string");
            var instance = Journal.get();
            try
            {
                var jsonNode = instance.constructJsonNode(InformalFieldNameHandler.parse(json));
                var eventClass = instance.getEventClass(jsonNode);
                return Optional.ofNullable(instance.fromJson(jsonNode.toString(), eventClass));
            } catch (IOException e)
            {
                Logger.error(e);
                return Optional.empty();
            }
        }

        private JsonNode constructJsonNode(String json) throws IOException
        {
            Objects.requireNonNull(json, "cannot construct JsonNode from null string");
            JsonFactory factory = mapper.get().getFactory();
            JsonParser parser = factory.createParser(json);
            return mapper.get().readTree(parser);
        }

        @SuppressWarnings("unchecked")
        private <T extends Event> Class<T> getEventClass(JsonNode node)
        {
            Objects.requireNonNull(node, "cannot get ClassEvent from null JsonNode");
            var subtype = SubtypeHandler.getSubtypeIfPresent(node);
            if (subtype.isPresent())
            {
                return (Class<T>) subtype.get();
            }

            return (Class<T>) events.get(node.get("event").asText());
        }

        private <T extends Event> T fromJson(String json, Class<T> type)
        {
            try
            {
                return mapper.get().readValue(json, type);
            } catch (JsonProcessingException e)
            {
                Logger.error(e);
                return null;
            }
        }

        @NoArgsConstructor(access = AccessLevel.PACKAGE)
        static final class Mapper
        {
            @Setter(AccessLevel.PRIVATE)
            private JsonMapper mapper = defaultMapper();

            JsonMapper get()
            {
                return mapper;
            }

            private JsonMapper.Builder copyMapper()
            {
                return mapper.rebuild();
            }

            private JsonMapper defaultMapper()
            {
                return JsonMapper.builder().propertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE).visibility(PropertyAccessor.FIELD, Visibility.ANY).configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, false)
                                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(SerializationFeature.INDENT_OUTPUT, true).defaultPrettyPrinter(PRINTER).build();
            }

            String asString(Object obj, @Nullable JsonValueOption... options)
            {
                for (JsonValueOption jsonValueOption : options)
                {
                    mapper(jsonValueOption.setMapperOption(copyMapper()));
                }

                final String str = asString(obj);

                mapper(defaultMapper());

                return str;
            }

            String asString(Object obj)
            {
                try
                {
                    if (obj instanceof Optional)
                    {
                        if (((Optional<?>) obj).isPresent())
                            return mapper.writeValueAsString(((Optional<?>) obj).get());
                        else
                            return "not present";
                    }
                    return mapper.writeValueAsString(obj);
                } catch (JsonProcessingException e)
                {
                    Logger.error(e);
                    e.printStackTrace();
                    return "Error";
                }
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
            if (instance == null)
            {
                synchronized (CAPI.class)
                {
                    if (instance == null)
                    {
                        instance = new CAPI(new CAPI.Mapper());
                    }
                }
            }
            return instance;
        }

        public static <T extends CAPIData> Optional<T> parse(String json, Class<T> type)
        {
            try
            {
                return Optional.ofNullable(get().mapper.get().readValue(json, type));
            } catch (JsonProcessingException e)
            {
                Logger.error(e);
                return Optional.empty();
            }
        }

        public static <T extends CAPIData> Optional<T> parse(File file, Class<T> type)
        {
            try
            {
                return Optional.ofNullable(get().mapper.get().readValue(file, type));
            } catch (IOException e)
            {
                Logger.error(e);
                e.printStackTrace();
                return Optional.empty();
            }
        }

        @NoArgsConstructor(access = AccessLevel.PACKAGE)
        static final class Mapper
        {
            @Setter(AccessLevel.PRIVATE)
            private JsonMapper mapper = defaultMapper();

            JsonMapper get()
            {
                return mapper;
            }

            private JsonMapper.Builder copyMapper()
            {
                return mapper.rebuild();
            }

            private JsonMapper defaultMapper()
            {
                return JsonMapper.builder().serializationInclusion(Include.NON_NULL).visibility(PropertyAccessor.FIELD, Visibility.ANY).configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, false).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                                .configure(SerializationFeature.INDENT_OUTPUT, true).defaultPrettyPrinter(PRINTER).build();
            }

            String asString(Object obj, @Nullable JsonValueOption... options)
            {
                for (JsonValueOption jsonValueOption : options)
                {
                    mapper(jsonValueOption.setMapperOption(copyMapper()));
                }

                final String str = asString(obj);

                mapper(defaultMapper());

                return str;
            }

            String asString(Object object)
            {
                try
                {
                    if (object instanceof Optional)
                    {
                        if (((Optional<?>) object).isPresent())
                            return mapper.writeValueAsString(((Optional<?>) object).get());
                        else
                            return "not present";
                    }
                    return mapper.writeValueAsString(object);
                } catch (JsonProcessingException e)
                {
                    Logger.error(e);
                    e.printStackTrace();
                    return "Error";
                }
            }
        }
    }
}
