/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;

import org.atteo.classindex.ClassIndex;
import org.tinylog.Logger;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import elite.dangerous.capi.CAPIData;
import elite.dangerous.journal.Event;

public class Elite4J
{
    
    /* !formatter */
    private static final ObjectMapper OUTPUT_MAPPER = new ObjectMapper()
        .setSerializationInclusion(Include.NON_NULL)
        .setVisibility(PropertyAccessor.FIELD, Visibility.ANY)
        .enable(SerializationFeature.INDENT_OUTPUT)
        .disable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        .setDefaultPrettyPrinter(new DefaultPrettyPrinter().withArrayIndenter(new DefaultIndenter("    ", DefaultIndenter.SYS_LF)));
    /* @formatter */

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

        public static <T extends Event> Optional<T> parse(String json)
        {
            Objects.requireNonNull(json, "cannot parse from null string");
            var instance = Journal.get();
            try
            {
                var jsonNode = instance.constructJsonNode(InformalFieldNameHandler.parse(json));
                Class<T> eventClass = instance.getEventClass(jsonNode);
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

        static final class Mapper extends JsonMapper
        {
            private static final long serialVersionUID = 5727134984977613956L;

            private volatile static Journal.Mapper instance;

            Journal.Mapper get()
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

        static final class Mapper extends JsonMapper
        {
            private static final long serialVersionUID = 5727134984977613956L;

            private volatile static CAPI.Mapper instance;

            CAPI.Mapper get()
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
