/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.stationservices;

import java.util.Date;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class MissionAccepted.
 */
@SuperBuilder
@Jacksonized
public class MissionAccepted extends Event 
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
     * The localised name.
     */
    public String localisedName;
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
     * The influence.
     */
    public String influence;
    /**
     * The reputation.
     */
    public String reputation;
    /**
     * The reward.
     */
    public Long   reward;
    /**
     * The mission ID.
     */
    public Long   missionID;
    /**
     * The expiry.
     */
    public Date   expiry;
}
