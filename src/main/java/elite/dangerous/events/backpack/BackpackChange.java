package elite.dangerous.events.backpack;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.backpack.BackpackItem;

/**
 * The Class BackpackChange.
 */
public class BackpackChange extends Event implements Trigger {
    
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
