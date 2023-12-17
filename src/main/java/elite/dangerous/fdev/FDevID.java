package elite.dangerous.fdev;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import elite.dangerous.fdev.FDevID.DeserializeAdapter;
import elite.dangerous.fdev.FDevID.SerializeAdapter;
import elite.dangerous.model.inerf.ID;
import lombok.AllArgsConstructor;
import space.tscg.misc.Validator;

@AllArgsConstructor
@SuppressWarnings("serial")
@JsonDeserialize(using = DeserializeAdapter.class)
@JsonSerialize(using = SerializeAdapter.class)
public final class FDevID implements ID
{
    private final Object id;

    @Override
    public String asText()
    {
        return id.toString();
    }

    @Override
    public Long toLong()
    {
        return Validator.Long(id.toString());
    }

    static class SerializeAdapter extends StdSerializer<FDevID>
    {
        public SerializeAdapter()
        {
            super(FDevID.class);
        }

        @Override
        public void serialize(FDevID value, JsonGenerator gen, SerializerProvider provider) throws IOException
        {
            gen.writePOJO(value.toLong());
        }
    }

    static class DeserializeAdapter extends StdDeserializer<FDevID>
    {
        protected DeserializeAdapter()
        {
            super(FDevID.class);
        }

        @Override
        public FDevID deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException
        {
            JsonNode node = p.getCodec().readTree(p);
            return new FDevID(node.asText());
        }
    }
}
