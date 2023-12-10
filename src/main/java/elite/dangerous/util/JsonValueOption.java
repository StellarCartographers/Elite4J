package elite.dangerous.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.json.JsonMapper;

public enum JsonValueOption
{
    INCLUDE_NULLS {
        @Override
        public JsonMapper setMapperOption(JsonMapper.Builder builder)
        {
            return builder.serializationInclusion(Include.ALWAYS).build();
        }
    };

    public abstract JsonMapper setMapperOption(JsonMapper.Builder builder);
}
