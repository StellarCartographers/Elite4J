package elite.dangerous.capi.modal.fleetcarrier;

import java.util.List;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class CarrierLocker
{
    private List<LockerItem> assets;
    private List<LockerItem> goods;
    private List<LockerItem> data;

    @Value
    @Builder
    public static class LockerItem
    {
        private String id;
        private String quantity;
        private String name;
        private String locName;
    }
}
