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
 * The Class CarrierDecommission.
 */
@SuperBuilder
@Jacksonized
public class CarrierDecommission extends Event 
{

    /**
     * The carrier ID.
     */
    public Long carrierID;
    /**
     * The scrap refund.
     */
    public Long scrapRefund;
    /**
     * The scrap time.
     */
    public Long scrapTime;
}
