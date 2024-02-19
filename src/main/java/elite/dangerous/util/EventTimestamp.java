/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.*;

import elite.dangerous.util.EventTimestamp.*;

@JsonSerialize(using = Serialization.class)
@JsonDeserialize(using = Deserialization.class)
public final class EventTimestamp
{
    private String source;

    private EventTimestamp(String source)
    {
        this.source = source;
    }

    public static final EventTimestamp of(String source)
    {
        return new EventTimestamp(source);
    }

    public Instant asInstant()
    {
        return Instant.from(ZonedDateTime.parse(source).withZoneSameInstant(ZoneId.of("UTC")));
    }

    public static class Serialization extends StdSerializer<EventTimestamp>
    {
        private static final long serialVersionUID = -6670569536298587549L;

        public Serialization()
        {
            super(EventTimestamp.class);
        }

        @Override
        public void serialize(EventTimestamp value, JsonGenerator gen, SerializerProvider provider) throws IOException
        {
            gen.writePOJO(value.source);
        }
    }

    public static class Deserialization extends StdDeserializer<EventTimestamp>
    {
        public Deserialization()
        {
            super(EventTimestamp.class);
        }

        private static final long serialVersionUID = 1939194103810318497L;

        @Override
        public EventTimestamp deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException
        {
            JsonNode node = p.getCodec().readTree(p);
            return EventTimestamp.of(node.asText());
        }
    }
}
