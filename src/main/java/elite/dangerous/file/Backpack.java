/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.file;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.backpack.BackpackItem;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Backpack.
 */
@SuperBuilder
@Jacksonized
public class Backpack extends Event
{
    /**
     * The items.
     */
    public List<BackpackItem> items;
    /**
     * The components.
     */
    public List<BackpackItem> components;
    /**
     * The consumables.
     */
    public List<BackpackItem> consumables;
    /**
     * The data.
     */
    public List<BackpackItem> data;
}
