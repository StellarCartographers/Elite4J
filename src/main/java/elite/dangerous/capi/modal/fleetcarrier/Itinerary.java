package elite.dangerous.capi.modal.fleetcarrier;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Itinerary
{
    @JsonProperty("completed")
    private List<Completed> completedJumps;
    private String          totalDistanceJumped;
    private String          currentJump;

    @Data
    @Builder
    @Jacksonized
    public static class Completed
    {
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date   departureTime;
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date   arrivalTime;
        private String state;
        private long visitDurationSeconds;
        private String starsystem;
        
        @JsonIgnore
        public Duration visitDuration()
        {
            return Duration.ofSeconds(visitDurationSeconds);
        }
    }
}
