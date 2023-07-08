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
 * The Class ShipyardSwap.
 */
@SuperBuilder
@Jacksonized
public class ShipyardSwap extends Event 
{

    /**
     * The store old ship.
     */
    public String  shipType, shipTypeLocalised, storeOldShip;
    /**
     * The store ship ID.
     */
    public Integer shipID, storeShipID;
    /**
     * The market ID.
     */
    public Long    marketID;
}
