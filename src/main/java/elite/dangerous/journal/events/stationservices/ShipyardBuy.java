package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;

public class ShipyardBuy extends Event
{

    public String shipType, sellOldShip;

    public long shipPrice, sellPrice;

    public int sellShipID;

}
