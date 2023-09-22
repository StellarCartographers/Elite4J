package elite.dangerous.capi.modal.fleetcarrier;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public enum Theme
{
    Default,
    @SerializedName("Anti-Xeno")
    @JsonProperty("Anti-Xeno")
    AntiXeno,
    Mercenary,
    @SerializedName("Bounty Hunter")
    @JsonProperty("Bounty Hunter")
    BountyHunter,
    Explorer,
    Piracy,
    @SerializedName("Search and Rescue")
    @JsonProperty("Search and Rescue")
    SearchAndRescue,
    Salvage,
    Mining,
    Trader,
    Smuggler;
}
