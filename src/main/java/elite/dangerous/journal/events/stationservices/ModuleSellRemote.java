package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;

public class ModuleSellRemote extends Event
{

    public int storageSlot, shipID;

    public String sellItem;

    public String ship;

    public long serverID, sellPrice;

}
