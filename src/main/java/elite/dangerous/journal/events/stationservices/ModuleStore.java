package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ModuleStore extends Event
{

    private String  slot;

    private String  storedItem;

    private String  ship;

    private int     shipID;

    private boolean hot;

    private long    marketID;

}
