package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ModuleSwap extends Event
{

    private long   marketID;

    private String fromSlot, toSlot, fromItem, toItem, ship;

    private int    shipID;

}
