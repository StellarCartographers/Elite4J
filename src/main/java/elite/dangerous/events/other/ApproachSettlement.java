/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.other;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class ApproachSettlement.
 */
@SuperBuilder
@Jacksonized
public class ApproachSettlement extends Event 
{

    /**
     * The name.
     */
    public String  name;
    /**
     * The body name.
     */
    public String  bodyName;
    /**
     * The body ID.
     */
    public Integer bodyID;
    /**
     * The latitude.
     */
    public Double  latitude;
    /**
     * The longitude.
     */
    public Double  longitude;
    /**
     * The market ID.
     */
    public Long    marketID;
    /**
     * The system address.
     */
    public Long    systemAddress;
}
