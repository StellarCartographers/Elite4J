/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.exploration;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class DiscoveryScan.
 */
@SuperBuilder
@Jacksonized
public class DiscoveryScan extends Event 
{

    /**
     * The system address.
     */
    public Long    systemAddress;
    /**
     * The bodies.
     */
    public Integer bodies;
}
