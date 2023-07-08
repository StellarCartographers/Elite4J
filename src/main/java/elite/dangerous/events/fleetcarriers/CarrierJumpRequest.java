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
 * The Class CarrierJumpRequest.
 */
@SuperBuilder
@Jacksonized
public class CarrierJumpRequest extends Event 
{

    /**
     * The carrier ID.
     */
    public Long    carrierID;
    /**
     * The system name.
     */
    public String  systemName;
    /**
     * The body.
     */
    public String  body;
    /**
     * The system address.
     */
    public Long    systemAddress;
    /**
     * The body ID.
     */
    public Integer bodyID;
    /**
     * The departure time.
     */
    public String  departureTime;
}
