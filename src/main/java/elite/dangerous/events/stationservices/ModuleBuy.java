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
 * The Class ModuleBuy.
 */
@SuperBuilder
@Jacksonized
public class ModuleBuy extends Event 
{

    /**
     * The slot.
     */
    public String  slot;
    /**
     * The stored item.
     */
    public String  storedItem;
    /**
     * The stored item localised.
     */
    public String  storedItemLocalised;
    /**
     * The buy item.
     */
    public String  buyItem;
    /**
     * The buy item localised.
     */
    public String  buyItemLocalised;
    /**
     * The ship.
     */
    public String  ship;
    /**
     * The sell item.
     */
    public String  sellItem;
    /**
     * The sell item localised.
     */
    public String  sellItemLocalised;
    /**
     * The buy price.
     */
    public Long    buyPrice;
    /**
     * The market ID.
     */
    public Long    marketID;
    /**
     * The sell price.
     */
    public Long    sellPrice;
    /**
     * The ship ID.
     */
    public Integer shipID;
}
