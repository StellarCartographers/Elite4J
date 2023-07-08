/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.base;

import lombok.experimental.SuperBuilder;

/**
 * The Class Squadron.
 */
@SuperBuilder
public abstract class Squadron extends Event
{
    /**
     * The squadron name.
     */
    public String squadronName;
}
