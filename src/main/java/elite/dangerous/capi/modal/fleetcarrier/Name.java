package elite.dangerous.capi.modal.fleetcarrier;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import elite.dangerous.utils.adapter.FleetCarrierNameAdapter;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "Instantiator", buildMethodName = "newInstance")
@JsonDeserialize(using = FleetCarrierNameAdapter.class)
public class Name
{
    private String callsign;
    private String vanityName;
    private String filteredVanityName;
}
