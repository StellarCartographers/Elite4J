package elite.dangerous.capi.meta;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class CarrierLocker
{
    @SerializedName("assets")
    private List<LockerItem> assets;
    @SerializedName("goods")
    private List<LockerItem> goods;
    @SerializedName("data")
    private List<LockerItem> data;

    @Value
    @Builder
    public static class LockerItem
    {
        @SerializedName("id")
        private String id;
        @SerializedName("quantity")
        private String quantity;
        @SerializedName("name")
        private String name;
        @SerializedName("locName")
        private String locName;
    }
}
