/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi.modal.fc;

import lombok.EliteObject;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

@EliteObject
@JsonPropertyOrder({"completedJumps", "totalDistanceJumpedLY", "currentJump"})
public class Itinerary
{
    @JsonProperty("completed")
    private List<Completed> completedJumps;
    @JsonProperty("totalDistanceJumpedLY")
    private int             totalDistanceJumped;
    private String          currentJump;
}
