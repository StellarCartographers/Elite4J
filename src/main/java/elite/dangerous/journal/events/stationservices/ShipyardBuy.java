package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ShipyardBuy extends Event
{

    private String shipType, sellOldShip;

    private long   shipPrice, sellPrice;

    private int    sellShipID;

}
