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
 * The Class ShipyardSell.
 */
@SuperBuilder
@Jacksonized
public class ShipyardSell extends Event 
{

    /**
     * The ship type localised.
     */
    public String  shipType, shipTypeLocalised;
    /**
     * The sell ship ID.
     */
    public Integer sellShipID;
    /**
     * The market ID.
     */
    public Long    shipPrice, marketID;
}
