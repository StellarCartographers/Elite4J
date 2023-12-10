package elite.dangerous.journal.events.fleetcarriers;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CarrierDecommission extends Event
{

    private long carrierID;

    private long scrapRefund;

    private long scrapTime;

}
