package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class FetchRemoteModule extends Event
{

    private int    storageSlots;

    private int    serverId;

    private int    transferCost;

    private int    transferTime;

    private int    shipId;

    private String storedItem;

    private String ship;

}
