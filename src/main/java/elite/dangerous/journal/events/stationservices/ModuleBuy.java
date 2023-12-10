package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ModuleBuy extends Event
{

    private String slot;

    private String storedItem;

    private String buyItem;

    private String ship;

    private String sellItem;

    private long   buyPrice;

    private long   marketID;

    private long   sellPrice;

    private int    shipID;

}
