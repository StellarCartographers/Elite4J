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
 * The Class ModuleSellRemote.
 */
@SuperBuilder
@Jacksonized
public class ModuleSellRemote extends Event 
{

    /**
     * The ship ID.
     */
    public Integer storageSlot, shipID;
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
     * The sell price.
     */
    public Long    serverID, sellPrice;
}
