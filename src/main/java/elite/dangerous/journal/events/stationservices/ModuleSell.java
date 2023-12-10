package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ModuleSell extends Event
{

    private String slot;

    private String sellItem;

    private String ship;

    private long   sellPrice, marketID;

    private int    shipID;

}
