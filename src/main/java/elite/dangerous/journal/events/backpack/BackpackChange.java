package elite.dangerous.journal.events.backpack;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.backpack.BackpackItem;
import lombok.EliteObject;

/**
 * This is written when there is any change to the contents of the suit backpack
 * 
 * @apiNote note this can be written at the same time as other events like
 *          {@link elite.dangerous.journal.events.backpack.UseConsumable UseConsumable}
 */
@EliteObject
public class BackpackChange extends Event
{
    private List<BackpackItem> added;

    private List<BackpackItem> removed;
}
