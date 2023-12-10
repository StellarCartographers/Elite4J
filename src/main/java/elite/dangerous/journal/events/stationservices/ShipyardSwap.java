package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ShipyardSwap extends Event
{

    private String shipType, storeOldShip;

    private int    shipID, storeShipID;

    private long   marketID;

}
