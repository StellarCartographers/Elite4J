package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ModuleSellRemote extends Event
{

    private int    storageSlot, shipID;

    private String sellItem;

    private String ship;

    private long   serverID, sellPrice;

}
