package elite.dangerous.capi.modal.fleetcarrier;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Reputation
{
    private String faction;
    private int    score;
}
