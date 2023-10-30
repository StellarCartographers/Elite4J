package elite.dangerous.capi.modal.fleetcarrier;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder(builderMethodName = "Instantiator", buildMethodName = "newInstance")
@Jacksonized
public class Name
{
    private String callsign;
    private String vanityName;
    private String filteredVanityName;
    
    @JsonIgnore
    public String getName()
    {
        var output = new StringBuilder("");
        for (var i = 0; i < vanityName.length(); i += 2)
        {
            var str = vanityName.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }
        return output.toString();
    
    }
}
