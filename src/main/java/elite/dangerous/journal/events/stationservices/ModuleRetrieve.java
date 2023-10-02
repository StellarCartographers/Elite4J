package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.Event;

public class ModuleRetrieve extends Event
{

    public long marketID;

    public String slot;

    public String retrievedItem;

    public String retrievedItemLocalised;

    public String ship;

    public String swapOutItem;

    public String swapOutItemLocalised;

    public int shipID;

    public boolean hot;

}
