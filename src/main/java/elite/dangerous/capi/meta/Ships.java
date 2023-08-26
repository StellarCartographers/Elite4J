package elite.dangerous.capi.meta;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Ships
{
    @SerializedName("shipyard_list")
    private List<Ship> shipyard;

    @Value
    @Builder
    @Jacksonized
    public static class Ship
    {
        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;
        @SerializedName("baseValue")
        private int    baseValue;
        @SerializedName("sku")
        private String sku;
        @SerializedName("stock")
        private int    stock;
    }
}
