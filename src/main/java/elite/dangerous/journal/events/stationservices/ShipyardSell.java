package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ShipyardSell extends Event
{

    private String shipType;

    private int    sellShipID;

    private long   shipPrice, marketID;

}
