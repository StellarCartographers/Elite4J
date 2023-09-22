package elite.dangerous.utils.deserializer;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import elite.dangerous.capi.modal.fleetcarrier.Name;

public class FleetCarrierNameAdapter implements JsonDeserializer<Name> {
    @Override
    public Name deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        var name = Name.Instantiator();
        var obj  = json.getAsJsonObject();
        name.callsign(obj.get("callsign").getAsString());;
        name.vanityName(hexToAscii(obj.get("vanityName").getAsString()));;
        name.filteredVanityName(hexToAscii(obj.get("vanityName").getAsString()));;
        return name.newInstance();
    }

    private String hexToAscii(String hexStr) {
        var output = new StringBuilder("");
        for (var i = 0; i < hexStr.length(); i += 2) {
            var str = hexStr.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }
        return output.toString();
    }
}
