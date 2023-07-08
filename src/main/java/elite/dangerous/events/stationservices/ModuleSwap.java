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
 * The Class ModuleSwap.
 */
@SuperBuilder
@Jacksonized
public class ModuleSwap extends Event 
{

    /**
     * The market ID.
     */
    public Long    marketID;
    /**
     * The ship.
     */
    public String  fromSlot, toSlot, fromItem, fromItemLocalised, toItem, toItemLocalised, ship;
    /**
     * The ship ID.
     */
    public Integer shipID;
}
