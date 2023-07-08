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
 * The Class ModuleSell.
 */
@SuperBuilder
@Jacksonized
public class ModuleSell extends Event 
{

    /**
     * The slot.
     */
    public String  slot;
    /**
     * The sell item.
     */
    public String  sellItem;
    /**
     * The sell item localised.
     */
    public String  sellItemLocalised;
    /**
     * The ship.
     */
    public String  ship;
    /**
     * The market ID.
     */
    public Long    sellPrice, marketID;
    /**
     * The ship ID.
     */
    public Integer shipID;
}
