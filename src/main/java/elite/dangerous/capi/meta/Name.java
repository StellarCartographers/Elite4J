package elite.dangerous.capi.meta;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "Instantiator", buildMethodName = "newInstance")
public class Name {
    private String callsign, vanityName, filteredVanityName;
}
