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
 * The Class StartJump.
 */
@SuperBuilder
@Jacksonized
public class StartJump extends Event 
{

    /**
     * The Constant JUMP_TYPE_HYPERSPACE.
     */
    public static final String JUMP_TYPE_HYPERSPACE  = "Hyperspace";
    /**
     * The Constant JUMP_TYPE_SUPERCRUISE.
     */
    public static final String JUMP_TYPE_SUPERCRUISE = "Supercruise";
    /**
     * The star class.
     */
    public String              jumpType, starSystem, starClass;
    /**
     * The system address.
     */
    public Long                systemAddress;
}
