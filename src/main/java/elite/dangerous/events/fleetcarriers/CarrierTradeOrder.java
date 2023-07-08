/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.fleetcarriers;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class CarrierTradeOrder.
 */
@SuperBuilder
@Jacksonized
public class CarrierTradeOrder extends Event 
{

    /**
     * The carrier ID.
     */
    public Long    carrierID;
    /**
     * The black market.
     */
    public Boolean blackMarket;
    /**
     * The commodity.
     */
    public String  commodity;
    /**
     * The purchase order.
     */
    public Integer purchaseOrder;
    /**
     * The sale order.
     */
    public Integer saleOrder;
    /**
     * The cancel trade.
     */
    public Boolean cancelTrade;
    /**
     * The price.
     */
    public Integer price;
}
