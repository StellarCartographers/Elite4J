package elite.dangerous.utils;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Json
{
    private final JsonObject o;
    
    public Json(JsonElement e)
    {
        this.o = e.getAsJsonObject();
    }
    
    public JsonArray getArray(String key)
    {
        return this.o.get(key).getAsJsonArray();
    }

    public String asString(String key)
    {
        return this.o.get(key).getAsString();
    }
    
    public long asLong(String key)
    {
        return this.o.get(key).getAsLong();
    }
    
    public int asInt(String key)
    {
        return this.o.get(key).getAsInt();
    }
    
    public double asDouble(String key)
    {
        return this.o.get(key).getAsDouble();
    }
    
    public float asFloat(String key)
    {
        return this.o.get(key).getAsFloat();
    }
    
    public boolean asBoolean(String key)
    {
        return this.o.get(key).getAsBoolean();
    }
    
    public byte asByte(String key)
    {
        return this.o.get(key).getAsByte();
    }
    
    public BigInteger asBigInt(String key)
    {
        return this.o.get(key).getAsBigInteger();
    }
    
    public BigDecimal asBigDecimal(String key)
    {
        return this.o.get(key).getAsBigDecimal();
    }
}
