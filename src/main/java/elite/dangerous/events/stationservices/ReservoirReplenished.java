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
 * The Class ReservoirReplenished.
 */
@SuperBuilder
@Jacksonized
public class ReservoirReplenished extends Event 
{

    /**
     * The fuel main.
     */
    public Double fuelMain;
    /**
     * The fuel reservoir.
     */
    public Double fuelReservoir;
}
