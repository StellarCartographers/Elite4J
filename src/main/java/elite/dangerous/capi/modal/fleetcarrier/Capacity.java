package elite.dangerous.capi.modal.fleetcarrier;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Capacity
{
    @SerializedName("shipPacks")
    private int shipPacks;
    @SerializedName("modulePacks")
    private int modulePacks;
    @SerializedName("cargoForSale")
    private int cargoForSale;
    @SerializedName("cargoNotForSale")
    private int cargoNotForSale;
    @SerializedName("cargoSpaceReserved")
    private int cargoSpaceReserved;
    @SerializedName("crew")
    private int crew;
    @SerializedName("freeSpace")
    private int freeSpace;
    @SerializedName("microresourceCapacityTotal")
    private int microresourceCapacityTotal;
    @SerializedName("microresourceCapacityFree")
    private int microresourceCapacityFree;
    @SerializedName("microresourceCapacityUsed")
    private int microresourceCapacityUsed;
    @SerializedName("microresourceCapacityReserved")
    private int microresourceCapacityReserved;
}
