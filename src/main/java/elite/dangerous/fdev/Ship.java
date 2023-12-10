package elite.dangerous.fdev;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Ship
{
    private int    fdevId;
    private String symbol;
    private String name;
}
