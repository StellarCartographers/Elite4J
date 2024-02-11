/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi.modal.fc;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
