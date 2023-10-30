package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;

public class ModuleRetrieve extends Event
{

    public long marketID;

    public String slot;

    public String retrievedItem;

    public String ship;

    public String swapOutItem;

    public int shipID;

    public boolean hot;

}
