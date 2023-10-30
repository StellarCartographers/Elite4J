package elite.dangerous.journal.events.backpack;

import elite.dangerous.journal.base.Event;

public class CollectItems extends Event
{

    public String name;

    public String type;

    public long ownerID;

    public int count;

    public boolean stolen;

}
