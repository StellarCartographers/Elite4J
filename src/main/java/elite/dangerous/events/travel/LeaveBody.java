/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.travel;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class LeaveBody.
 */
@SuperBuilder
@Jacksonized
public class LeaveBody extends Event 
{

    /**
     * The body.
     */
    public String  starSystem, body;
    /**
     * The system address.
     */
    public Long    systemAddress;
    /**
     * The body ID.
     */
    public Integer bodyID;
}
