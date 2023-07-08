/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.stationservices;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class MissionCompleted.
 */
@SuperBuilder
@Jacksonized
public class MissionCompleted extends Event 
{

    /**
     * The faction.
     */
    public String faction;
    /**
     * The name.
     */
    public String name;
    /**
     * The target faction.
     */
    public String targetFaction;
    /**
     * The destination system.
     */
    public String destinationSystem;
    /**
     * The destination station.
     */
    public String destinationStation;
    /**
     * The mission ID.
     */
    public Long   missionID;
    /**
     * The reward.
     */
    public Long   reward;
}
