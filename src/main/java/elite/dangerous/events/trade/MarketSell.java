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
 * The Class MarketSell.
 */
@SuperBuilder
@Jacksonized
public class MarketSell extends Event 
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
     * The sell price.
     */
    public Integer sellPrice;
    /**
     * The total sale.
     */
    public Integer totalSale;
    /**
     * The avg price paid.
     */
    public Integer avgPricePaid;
    /**
     * The illegal goods.
     */
    public Boolean illegalGoods;
    /**
     * The stolen goods.
     */
    public Boolean stolenGoods;
    /**
     * The black market.
     */
    public Boolean blackMarket;
}
