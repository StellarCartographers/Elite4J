package elite.dangerous.capi.modal.fc;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.EliteObject;

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
