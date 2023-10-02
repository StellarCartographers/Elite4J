package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.Event;

public class ShipyardTransfer extends Event
{

    public String shipType, shipTypeLocalised, system;

    public int shipID;

    public long shipMarketID, transferPrice, transferTime, marketID;

    public double distance;

}
