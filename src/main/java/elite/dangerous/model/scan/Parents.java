package elite.dangerous.model.scan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import elite.dangerous.model.enums.BodyType;
import elite.dangerous.model.scan.Parents.ParentsAdapter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EliteObject;

@EliteObject
@JsonDeserialize(using = ParentsAdapter.class)
public class Parents
{
    private List<Parent> list;

    public int parentCount()
    {
        return this.list.size();
    }

    public List<Parent> listFromBodyType(BodyType bodyType)
    {
        return this.list.stream().filter(p -> p.type.equals(bodyType)).collect(Collectors.toList());
    }

    public Parent[] arrayFromBodyType(BodyType bodyType)
    {
        return listFromBodyType(bodyType).toArray(new Parent[0]);
    }

    @EliteObject
    @AllArgsConstructor(access = AccessLevel.PACKAGE)
    static class Parent
    {
        private BodyType type;

        private int      bodyID;
    }

    static class ParentsAdapter extends StdDeserializer<Parents>
    {
        private static final long serialVersionUID = -3893319142982540675L;

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
            Parents p = new Parents();
            p.list = new ArrayList<Parents.Parent>();

            n.forEach(node ->
            {
                node.fields().forEachRemaining(e -> p.list.add(new Parent(BodyType.fromString(e.getKey()), e.getValue().asInt())));
            });

            return p;
        }
    }
}
