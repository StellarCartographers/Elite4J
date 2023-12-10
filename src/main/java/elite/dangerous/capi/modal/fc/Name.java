package elite.dangerous.capi.modal.fc;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.EliteObject;
import lombok.Getter;

@EliteObject
public class Name
{
    private String callsign;
    @Getter(AccessLevel.NONE)
    private String vanityName;
    @Getter(AccessLevel.NONE)
    private String filteredVanityName;
    
    @JsonIgnore
    public String name()
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
