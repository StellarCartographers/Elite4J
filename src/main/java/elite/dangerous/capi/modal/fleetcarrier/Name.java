package elite.dangerous.capi.modal.fleetcarrier;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder(builderMethodName = "Instantiator", buildMethodName = "newInstance")
@Jacksonized
public class Name
{
    @SerializedName("callsign")
    private String callsign;
    @SerializedName("vanityName")
    private String vanityName;
    @SerializedName("filteredVanityName")
    private String filteredVanityName;
}
