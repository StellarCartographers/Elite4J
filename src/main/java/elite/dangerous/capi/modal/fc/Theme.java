package elite.dangerous.capi.modal.fc;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Theme
{
    Default,
    @JsonProperty("Anti-Xeno")
    AntiXeno,
    Mercenary,
    @JsonProperty("Bounty Hunter")
    BountyHunter,
    Explorer,
    Piracy,
    @JsonProperty("Search and Rescue")
    SearchAndRescue,
    Salvage,
    Mining,
    Trader,
    Smuggler;
}
