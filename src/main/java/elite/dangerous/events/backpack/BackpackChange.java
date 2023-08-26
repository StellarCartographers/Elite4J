package elite.dangerous.events.backpack;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.backpack.BackpackItem;

/**
 * This is written when there is any change to the contents of the suit backpack 
 * @apiNote note this can be written at the same time as other events like {@link elite.dangerous.events.backpack.UseConsumable UseConsumable}
 */
public class BackpackChange extends Event implements Trigger {
    private List<BackpackItem> added;

    private List<BackpackItem> removed;

    /**
     * @return List of {@link elite.dangerous.models.backpack.BackpackItem BackpackItem}s that were added, if any
     */
    public List<BackpackItem> getAdded() {
        return added;
    }

    /**
     * @return List of {@link elite.dangerous.models.backpack.BackpackItem BackpackItem}s that were removed, if any
     */
    public List<BackpackItem> getRemoved() {
        return removed;
    }
}
