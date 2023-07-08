/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.stationservices;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class CommunityGoalReward.
 */
@SuperBuilder
@Jacksonized
public class CommunityGoalReward extends Event 
{

    /**
     * The cgid.
     */
    @SerializedName("CGID")
    public Integer cgid;
    /**
     * The reward.
     */
    public Integer reward;
    /**
     * The name.
     */
    public String  name;
    /**
     * The system.
     */
    public String  system;
}
