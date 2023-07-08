/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.backpack;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.backpack.BackpackItem;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class BackpackChange.
 */
@SuperBuilder
@Jacksonized
public class BackpackChange extends Event 
{

    private List<BackpackItem> added;
    private List<BackpackItem> removed;

    /**
     * @return List of {@link BackpackItem}s that were added, if any
     */
    public List<BackpackItem> getAdded()
    {
        return added;
    }

    /**
     * @return List of {@link BackpackItem}s that were removed, if any
     */
    public List<BackpackItem> getRemoved()
    {
        return removed;
    }
}
