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
 * The Class VehicleSwitch.
 */
@SuperBuilder
@Jacksonized
public class VehicleSwitch extends Event 
{

    /**
     * The Constant TOS.
     */
    public static final String[] TOS = {"Mothership", "Fighter"};
    /**
     * The to.
     */
    public String                to;
}
