package elite.dangerous.capi.modal.fleetcarrier;

import java.util.List;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Ships
{
    private List<Ship> shipyard;

    @Value
    @Builder
    @Jacksonized
    public static class Ship
    {
        private String id;
        private String name;
        private int    baseValue;
        private String sku;
        private int    stock;
    }
}
