package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;

public class ShipyardTransfer extends Event
{

    public String shipType, system;

    public int shipID;

    public long shipMarketID, transferPrice, transferTime, marketID;

    public double distance;

}
