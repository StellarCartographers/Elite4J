package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.Event;

public class ModuleSellRemote extends Event
{

    public int storageSlot, shipID;

    public String sellItem;

    public String sellItemLocalised;

    public String ship;

    public long serverID, sellPrice;

}
