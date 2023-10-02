package elite.dangerous.utils.adapter;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import elite.dangerous.journal.models.scan.Parents;

public class ParentsAdapter extends StdDeserializer<Parents>
{
    private static final long serialVersionUID = 1638830538069787741L;

    protected ParentsAdapter(Class<?> vc)
    {
        super(vc);
    }

    protected ParentsAdapter()
    {
        super(Parents.class);
    }

    @Override
    public Parents deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JacksonException
    {
        JsonNode n = parser.getCodec().readTree(parser);
        Parents  p = new Parents();

        n.forEach(node ->
        {
            node.fields().forEachRemaining(e -> p.add(e.getKey(), e.getValue().asInt()));
        });

        return p;
    }
}
