package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ModuleRetrieve extends Event
{

    private long    marketID;

    private String  slot;

    private String  retrievedItem;

    private String  ship;

    private String  swapOutItem;

    private int     shipID;

    private boolean hot;

}
