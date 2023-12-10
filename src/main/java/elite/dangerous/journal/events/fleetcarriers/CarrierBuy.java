package elite.dangerous.journal.events.fleetcarriers;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CarrierBuy extends Event
{

    private long   boughtAtMarket;

    private long   carrierID;

    private String location;

    private long   price;

    private String variant;

    private String callsign;

}
