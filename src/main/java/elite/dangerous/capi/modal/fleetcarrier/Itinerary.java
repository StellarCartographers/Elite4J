package elite.dangerous.capi.modal.fleetcarrier;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import elite.dangerous.utils.deserializer.UTCDateDeserializer;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Itinerary
{
    @SerializedName("completed")
    private List<Completed> completedJumps;
    @SerializedName("totalDistanceJumpedLY")
    private String          totalDistanceJumped;
    @SerializedName("currentJump")
    private String          currentJump;

    @Value
    @Builder
    @Jacksonized
    public static class Completed
    {
        @SerializedName("departureTime") @JsonAdapter(UTCDateDeserializer.class)
        private Date   departureTime;
        @SerializedName("arrivalTime") @JsonAdapter(UTCDateDeserializer.class)
        private Date   arrivalTime;
        @SerializedName("state")
        private String state;
        @SerializedName("visitDurationSeconds")
        private String visitDurationSeconds;
        @SerializedName("starsystem")
        private String starsystem;
    }
}
