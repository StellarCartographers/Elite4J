package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;

public class ModuleStore extends Event
{

    public String slot;

    public String storedItem;

    public String ship;

    public int shipID;

    public boolean hot;

    public long marketID;

}
