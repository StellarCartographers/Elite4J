package elite.dangerous.journal.events.backpack;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CollectItems extends Event
{
    private String  name;

    private String  type;

    private long    ownerID;

    private int     count;

    private boolean stolen;

}
