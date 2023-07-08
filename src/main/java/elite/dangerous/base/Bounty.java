/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.base;

import lombok.experimental.SuperBuilder;

/**
 * The Class Bounty.
 */
@SuperBuilder
public abstract class Bounty extends Event
{
    /**
     * The target.
     */
    public String target;
    /**
     * The victim faction.
     */
    public String victimFaction;
}
