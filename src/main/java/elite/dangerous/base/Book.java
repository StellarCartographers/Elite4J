/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.base;

import lombok.experimental.SuperBuilder;

/**
 * The Class Book.
 */
@SuperBuilder
public abstract class Book extends Event
{
    /**
     * The cost.
     */
    public Long   cost;
    /**
     * The destination system.
     */
    public String destinationSystem;
    /**
     * The destination location.
     */
    public String destinationLocation;
}
