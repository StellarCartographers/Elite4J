package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ShipyardTransfer extends Event
{

    private String shipType, system;

    private int    shipID;

    private long   shipMarketID, transferPrice, transferTime, marketID;

    private double distance;

}
