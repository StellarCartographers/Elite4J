package elite.dangerous.capi.modal.fc;

import java.time.Duration;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EliteObject;

@EliteObject
public class Completed
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