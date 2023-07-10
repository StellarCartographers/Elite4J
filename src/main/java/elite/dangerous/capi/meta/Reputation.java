package elite.dangerous.capi.meta;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Reputation {
    private String faction, score;
}
