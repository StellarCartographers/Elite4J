/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.powerplay;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class PowerplayFastTrack.
 */
@SuperBuilder
@Jacksonized
public class PowerplayFastTrack extends Event 
{

    /**
     * The power.
     */
    public String  power;
    /**
     * The cost.
     */
    public Integer cost;
}
