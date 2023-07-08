/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.trade;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class MarketBuy.
 */
@SuperBuilder
@Jacksonized
public class MarketBuy extends Event 
{

    /**
     * The market ID.
     */
    public Long    marketID;
    /**
     * The type.
     */
    public String  type;
    /**
     * The type localised.
     */
    public String  typeLocalised;
    /**
     * The count.
     */
    public Integer count;
    /**
     * The buy price.
     */
    public Integer buyPrice;
    /**
     * The total cost.
     */
    public Integer totalCost;
}
