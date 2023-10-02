package elite.dangerous.capi;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import elite.dangerous.capi.modal.fleetcarrier.Name;

public class FleetCarrierNameAdapter extends StdDeserializer<Name>
{

    private static final long serialVersionUID = -3709038638410018106L;

    protected FleetCarrierNameAdapter()
    {
        super(Name.class);
    }

    @Override
    public Name deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException
    {
        JsonNode node               = p.getCodec().readTree(p);
        var      callsign           = node.get("callsing").asText();
        var      vanityName         = hexToAscii(node.get("vanityName").asText());
        var      filteredVanityName = hexToAscii(node.get("filteredVanityName").asText());

        return Name.Instantiator().callsign(callsign).vanityName(vanityName).filteredVanityName(filteredVanityName).newInstance();
    }

    private String hexToAscii(String hexStr)
    {
        var output = new StringBuilder("");
        for (var i = 0; i < hexStr.length(); i += 2)
        {
            var str = hexStr.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }
        return output.toString();
    }
}
