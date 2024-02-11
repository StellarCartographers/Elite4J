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

import java.time.Duration;
import java.util.Date;

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