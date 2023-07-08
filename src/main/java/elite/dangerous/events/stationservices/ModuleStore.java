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
 * The Class ModuleStore.
 */
@SuperBuilder
@Jacksonized
public class ModuleStore extends Event 
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
     * The ship.
     */
    public String  ship;
    /**
     * The ship ID.
     */
    public Integer shipID;
    /**
     * The hot.
     */
    public Boolean hot;
    /**
     * The market ID.
     */
    public Long    marketID;
}
