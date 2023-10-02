package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.Event;

public class FetchRemoteModule extends Event
{

    public int storageSlots;

    public int serverId;

    public int transferCost;

    public int transferTime;

    public int shipId;

    public String storedItem;

    public String storedItemLocalised;

    public String ship;

}
