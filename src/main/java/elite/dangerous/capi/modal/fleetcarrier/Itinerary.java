package elite.dangerous.capi.modal.fleetcarrier;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Itinerary
{
    private List<Completed> completedJumps;
    private String          totalDistanceJumped;
    private String          currentJump;

    @Value
    @Builder
    @Jacksonized
    public static class Completed
    {
        private Date   departureTime;
        private Date   arrivalTime;
        private String state;
        private String visitDurationSeconds;
        private String starsystem;
    }
}
