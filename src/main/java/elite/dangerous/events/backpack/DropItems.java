/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.backpack;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class DropItems.
 */
@SuperBuilder
@Jacksonized
public class DropItems extends Event 
{

    /**
     * The name.
     */
    public String  name;
    /**
     * The type.
     */
    public String  type;
    /**
     * The owner ID.
     */
    public Long    ownerID;
    /**
     * The count.
     */
    public Integer count;
}
