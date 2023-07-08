/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.travel;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Touchdown.
 */
@SuperBuilder
@Jacksonized
public class Touchdown extends Event 
{

    /**
     * The player controlled.
     */
    public Boolean playerControlled;
    /**
     * The longitude.
     */
    public Double  latitude, longitude;
    /**
     * The nearest destination.
     */
    public String  nearestDestination;
    /**
     * The nearest destination localised.
     */
    public String  nearestDestinationLocalised;
}
