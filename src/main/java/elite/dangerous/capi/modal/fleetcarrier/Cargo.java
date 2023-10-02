package elite.dangerous.capi.modal.fleetcarrier;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Cargo
{
    private String  commodity;
    private String  originSystem;
    private boolean mission;
    private int     qty;
    private int     value;
    private boolean stolen;
    private String  locName;
}
