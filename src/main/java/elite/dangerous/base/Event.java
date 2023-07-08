/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.base;

import java.util.Date;

import lombok.experimental.SuperBuilder;

/**
 * The Class Event.
 */
@SuperBuilder
public abstract class Event
{
    /**
     * The timestamp.
     */
    public Date   timestamp;
    /**
     * The type.
     */
    public String event;
}
