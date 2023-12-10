package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class SellShipOnRebuy extends Event
{

    private String shipType;

    private String system;

    private int    sellShipId;

    private long   shipPrice;

}
