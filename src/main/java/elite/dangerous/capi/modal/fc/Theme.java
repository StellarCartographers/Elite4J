/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
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
