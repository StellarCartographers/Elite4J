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
 * The Class FetchRemoteModule.
 */
@SuperBuilder
@Jacksonized
public class FetchRemoteModule extends Event 
{

    /**
     * The storage slots.
     */
    public Integer storageSlots;
    /**
     * The server id.
     */
    public Integer serverId;
    /**
     * The transfer cost.
     */
    public Integer transferCost;
    /**
     * The transfer time.
     */
    public Integer transferTime;
    /**
     * The ship id.
     */
    public Integer shipId;
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
}
