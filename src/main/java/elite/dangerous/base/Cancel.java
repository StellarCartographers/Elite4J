/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.base;

import lombok.experimental.SuperBuilder;

/**
 * The Class Cancel.
 */
@SuperBuilder
public abstract class Cancel extends Event
{
    /**
     * The refund.
     */
    public Long refund;
}
