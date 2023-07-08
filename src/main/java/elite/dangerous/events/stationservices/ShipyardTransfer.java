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
 * The Class ShipyardTransfer.
 */
@SuperBuilder
@Jacksonized
public class ShipyardTransfer extends Event 
{

    /**
     * The system.
     */
    public String  shipType, shipTypeLocalised, system;
    /**
     * The ship ID.
     */
    public Integer shipID;
    /**
     * The market ID.
     */
    public Long    shipMarketID, transferPrice, transferTime, marketID;
    /**
     * The distance.
     */
    public Double  distance;
}
