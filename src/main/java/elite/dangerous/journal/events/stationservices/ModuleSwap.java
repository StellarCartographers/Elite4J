package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;

public class ModuleSwap extends Event
{

    public long marketID;

    public String fromSlot, toSlot, fromItem, toItem, ship;

    public int shipID;

}
