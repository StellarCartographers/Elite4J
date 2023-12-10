package elite.dangerous.util;

import java.util.function.Function;
import java.util.function.Predicate;

import com.fasterxml.jackson.databind.JsonNode;

public class NodeHelper
{
    public static Predicate<JsonNode> get(String fieldName, Function<JsonNode, Boolean> expr)
    {
        return node -> node.has(fieldName) && expr.apply(node);
    }
}
