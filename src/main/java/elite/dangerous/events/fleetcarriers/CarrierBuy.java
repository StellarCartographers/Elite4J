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
 * The Class CarrierBuy.
 */
@SuperBuilder
@Jacksonized
public class CarrierBuy extends Event 
{

    /**
     * The bought at market.
     */
    public Long   boughtAtMarket;
    /**
     * The carrier ID.
     */
    public Long   carrierID;
    /**
     * The location.
     */
    public String location;
    /**
     * The price.
     */
    public Long   price;
    /**
     * The variant.
     */
    public String variant;
    /**
     * The callsign.
     */
    public String callsign;
}
