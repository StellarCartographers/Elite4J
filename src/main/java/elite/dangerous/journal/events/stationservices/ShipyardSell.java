package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.Event;

public class ShipyardSell extends Event
{

    public String shipType, shipTypeLocalised;

    public int sellShipID;

    public long shipPrice, marketID;

}
