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
 * The Class CarrierNameChanged.
 */
@SuperBuilder
@Jacksonized
public class CarrierNameChanged extends Event 
{

    /**
     * The carrier ID.
     */
    public Long   carrierID;
    /**
     * The callsign.
     */
    public String callsign;
    /**
     * The name.
     */
    public String name;
}
