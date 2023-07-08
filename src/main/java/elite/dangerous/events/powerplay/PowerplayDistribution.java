/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.powerplay;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;

/**
 * The Class PowerplayDistribution.
 */
@SuperBuilder
public abstract class PowerplayDistribution extends Event
{

    /**
     * The power.
     */
    public String  power;
    /**
     * The type.
     */
    public String  type;
    /**
     * The count.
     */
    public Integer count;
}
