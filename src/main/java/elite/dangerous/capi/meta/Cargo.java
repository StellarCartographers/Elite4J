package elite.dangerous.capi.meta;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Cargo
{
    @SerializedName("commodity")
    private String  commodity;
    @SerializedName("originSystem")
    private String  originSystem;
    @SerializedName("mission")
    private boolean mission;
    @SerializedName("qty")
    private int     qty;
    @SerializedName("value")
    private int     value;
    @SerializedName("stolen")
    private boolean stolen;
    @SerializedName("locName")
    private String  locName;
}
