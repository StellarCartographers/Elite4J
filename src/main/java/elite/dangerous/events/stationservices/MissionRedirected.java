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
 * The Class MissionRedirected.
 */
@SuperBuilder
@Jacksonized
public class MissionRedirected extends Event 
{

    /**
     * The name.
     */
    public String name;
    /**
     * The new destination station.
     */
    public String newDestinationStation;
    /**
     * The new destination system.
     */
    public String newDestinationSystem;
    /**
     * The old destination station.
     */
    public String oldDestinationStation;
    /**
     * The old destination system.
     */
    public String oldDestinationSystem;
    /**
     * The mission ID.
     */
    public Long   missionID;
}
