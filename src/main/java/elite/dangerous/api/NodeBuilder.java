package elite.dangerous.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.lang.reflect.*;
import java.util.*;

public final class NodeBuilder
{
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static ObjectNode buildNode(Object object)
    {
        var objectClass = object.getClass();
        Method[] ifaceMethods = objectClass.getDeclaredMethods();
        var keyValueMap = new HashMap<String, Object>();
        for (int i = 0; i < ifaceMethods.length; i++)
        {
            var method = ifaceMethods[i];
            if(!method.getName().equals("toObjectNode"))
                keyValueMap.put(method.getName(), invokeMethod(method, object));
        }
        ObjectNode node = MAPPER.createObjectNode();
        for (Map.Entry<String, Object> entry : keyValueMap.entrySet())
        {
            var key = entry.getKey();
            var val = entry.getValue();
            addValue(node, key, val);
        }
        return node;
    }
    
    private static Object invokeMethod(Method method, Object object)
    {
        try
        {
            if(method.canAccess(object))
            {
                return method.invoke(object);
            } else {
                if (method.trySetAccessible()) {
                    return method.invoke(object);
                } else {
                    return "could-not-access";
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    private static void addValue(ObjectNode node, String key, Object obj)
    {
        if(String.class.isInstance(obj))
            node.put(key, (String) obj);
        else if(Boolean.class.isInstance(obj))
            node.put(key, (boolean) obj);
        else if(Double.class.isInstance(obj))
            node.put(key, (double) obj);
        else if(Float.class.isInstance(obj))
            node.put(key, (float) obj);
        else if(Long.class.isInstance(obj))
            node.put(key, (long) obj);
        else if(Integer.class.isInstance(obj))
            node.put(key, (int) obj);
    }
}
