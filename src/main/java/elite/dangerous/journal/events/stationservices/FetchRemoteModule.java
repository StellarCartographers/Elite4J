package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;

public class FetchRemoteModule extends Event
{

    public int storageSlots;

    public int serverId;

    public int transferCost;

    public int transferTime;

    public int shipId;

    public String storedItem;

    public String ship;

}
