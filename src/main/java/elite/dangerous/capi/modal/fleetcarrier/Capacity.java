package elite.dangerous.capi.modal.fleetcarrier;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Capacity
{
    private int shipPacks;
    private int modulePacks;
    private int cargoForSale;
    private int cargoNotForSale;
    private int cargoSpaceReserved;
    private int crew;
    private int freeSpace;
    private int microresourceCapacityTotal;
    private int microresourceCapacityFree;
    private int microresourceCapacityUsed;
    private int microresourceCapacityReserved;
}
