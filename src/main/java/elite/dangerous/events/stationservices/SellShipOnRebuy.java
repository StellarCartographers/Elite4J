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
 * The Class SellShipOnRebuy.
 */
@SuperBuilder
@Jacksonized
public class SellShipOnRebuy extends Event 
{

    /**
     * The ship type.
     */
    public String  shipType;
    /**
     * The system.
     */
    public String  system;
    /**
     * The sell ship id.
     */
    public Integer sellShipId;
    /**
     * The ship price.
     */
    public Long    shipPrice;
}
