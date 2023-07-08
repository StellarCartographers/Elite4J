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
 * The Class ModuleRetrieve.
 */
@SuperBuilder
@Jacksonized
public class ModuleRetrieve extends Event 
{

    /**
     * The market ID.
     */
    public Long    marketID;
    /**
     * The slot.
     */
    public String  slot;
    /**
     * The retrieved item.
     */
    public String  retrievedItem;
    /**
     * The retrieved item localised.
     */
    public String  retrievedItemLocalised;
    /**
     * The ship.
     */
    public String  ship;
    /**
     * The swap out item.
     */
    public String  swapOutItem;
    /**
     * The swap out item localised.
     */
    public String  swapOutItemLocalised;
    /**
     * The ship ID.
     */
    public Integer shipID;
    /**
     * The hot.
     */
    public Boolean hot;
}
