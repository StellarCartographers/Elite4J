package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.Event;

public class ModuleSwap extends Event
{

    public long marketID;

    public String fromSlot, toSlot, fromItem, fromItemLocalised, toItem, toItemLocalised, ship;

    public int shipID;

}
