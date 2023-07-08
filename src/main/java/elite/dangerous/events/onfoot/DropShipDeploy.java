/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.onfoot;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class DropShipDeploy.
 */
@SuperBuilder
@Jacksonized
public class DropShipDeploy extends Event 
{

    /**
     * The star system.
     */
    public String  starSystem;
    /**
     * The system address.
     */
    public Long    systemAddress;
    /**
     * The body.
     */
    public String  body;
    /**
     * The body ID.
     */
    public Long    bodyID;
    /**
     * The on station.
     */
    public Boolean onStation;
    /**
     * The on planet.
     */
    public Boolean onPlanet;
}
