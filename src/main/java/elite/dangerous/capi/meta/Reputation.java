package elite.dangerous.capi.meta;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Reputation
{
    @SerializedName("majorFaction")
    private String faction;
    @SerializedName("score")
    private int    score;
}
