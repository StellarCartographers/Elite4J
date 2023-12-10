package elite.dangerous.capi.modal.fc;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Reputation
{
    private String majorFaction;
    private int    score;
}
