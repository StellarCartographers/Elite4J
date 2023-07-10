package elite.dangerous.capi.meta;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Ships {
    @SerializedName("shipyard_list")
    private List<Ship> shipyard;

    @Value
    @Builder
    public static class Ship {
        private String id, name, baseValue, sku, stock;
    }
}
