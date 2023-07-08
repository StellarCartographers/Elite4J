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
 * The Class CarrierFinance.
 */
@SuperBuilder
@Jacksonized
public class CarrierFinance extends Event 
{

    /**
     * The reserve percent.
     */
    public Double taxRate, reservePercent;
    /**
     * The available balance.
     */
    public Long   carrierID, carrierBalance, reserveBalance, availableBalance;
}
