package elite.dangerous.capi.meta;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Capacity {
    @SerializedName("shipPacks")
    private String shipPacks;

    @SerializedName("modulePacks")
    private String modulePacks;

    @SerializedName("cargoForSale")
    private String cargoForSale;

    @SerializedName("cargoNotForSale")
    private String cargoNotForSale;

    @SerializedName("cargoSpaceReserved")
    private String cargoSpaceReserved;

    @SerializedName("crew")
    private String crew;

    @SerializedName("freeSpace")
    private String freeSpace;

    @SerializedName("microresourceCapacityTotal")
    private String microresourceCapacityTotal;

    @SerializedName("microresourceCapacityFree")
    private String microresourceCapacityFree;

    @SerializedName("microresourceCapacityUsed")
    private String microresourceCapacityUsed;

    @SerializedName("microresourceCapacityReserved")
    private String microresourceCapacityReserved;
}
