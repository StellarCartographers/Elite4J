package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;

public class ShipyardSell extends Event
{

    public String shipType;

    public int sellShipID;

    public long shipPrice, marketID;

}
