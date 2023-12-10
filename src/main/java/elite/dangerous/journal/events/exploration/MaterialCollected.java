package elite.dangerous.journal.events.exploration;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class MaterialCollected extends Event
{
    private String category;

    private String name;

    private int    count;

}
