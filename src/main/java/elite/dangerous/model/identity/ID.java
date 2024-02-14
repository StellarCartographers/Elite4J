package elite.dangerous.model.identity;

import lombok.AllArgsConstructor;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

import elite.dangerous.model.identity.ID.*;

@AllArgsConstructor
@JsonDeserialize(using = DeserializeAdapter.class)
@JsonSerialize(using = SerializeAdapter.class)
public sealed class ID permits IntID
{
    private final long id;
    
    public long asLong()
    {
        return id;
    }
    
    public String asText()
    {
        return String.valueOf(id);
    }

    static class SerializeAdapter extends StdSerializer<ID>
    {
        private static final long serialVersionUID = 4864627635363213903L;

        public SerializeAdapter()
        {
            super(ID.class);
        }

        @Override
        public void serialize(ID value, JsonGenerator gen, SerializerProvider provider) throws IOException
        {
            gen.writePOJO(value.asLong());
        }
    }

    static class DeserializeAdapter extends StdDeserializer<ID>
    {
        private static final long serialVersionUID = -3552438083695365026L;

        protected DeserializeAdapter()
        {
            super(ID.class);
        }

        @Override
        public ID deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException
        {
            JsonNode node = p.getCodec().readTree(p);
            return new ID(node.asLong());
        }
    }
}
