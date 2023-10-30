package elite.dangerous.journal.events.backpack;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.journal.models.backpack.BackpackItem;

public class Backpack extends Event
{

    public List<BackpackItem> items;

    public List<BackpackItem> components;

    public List<BackpackItem> consumables;

    public List<BackpackItem> data;
}
