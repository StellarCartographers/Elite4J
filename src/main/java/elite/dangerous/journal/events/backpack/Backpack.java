package elite.dangerous.journal.events.backpack;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.backpack.BackpackItem;
import lombok.EliteObject;

@EliteObject
public class Backpack extends Event
{
    private List<BackpackItem> items;

    private List<BackpackItem> components;

    private List<BackpackItem> consumables;

    private List<BackpackItem> data;
}
