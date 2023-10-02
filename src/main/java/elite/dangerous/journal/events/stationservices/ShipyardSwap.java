package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.Event;

public class ShipyardSwap extends Event
{

    public String shipType, shipTypeLocalised, storeOldShip;

    public int shipID, storeShipID;

    public long marketID;

}
