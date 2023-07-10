package elite.dangerous.capi.meta;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Cargo {
    @SerializedName("commodity")
    private String commodity;

    @SerializedName("originSystem")
    private String originSystem;

    @SerializedName("mission")
    private boolean mission;

    @SerializedName("qty")
    private String qty;

    @SerializedName("value")
    private String value;

    @SerializedName("stolen")
    private boolean stolen;

    @SerializedName("locName")
    private String locName;
}
