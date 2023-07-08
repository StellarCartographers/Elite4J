/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.file;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.market.MarketItem;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Market.
 */
@SuperBuilder
@Jacksonized
public class Market extends Event
{
    /**
     * The station name.
     */
    public String           stationName;
    /**
     * The star system.
     */
    public String           starSystem;
    /**
     * The station type.
     */
    public String           stationType;
    /**
     * The carrier docking access.
     */
    public String           carrierDockingAccess;
    /**
     * The market ID.
     */
    public Integer          marketID;
    /**
     * The items.
     */
    public List<MarketItem> items;
}
