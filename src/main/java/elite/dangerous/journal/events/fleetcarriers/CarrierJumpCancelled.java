package elite.dangerous.journal.events.fleetcarriers;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CarrierJumpCancelled extends Event
{

    private long carrierID;

}
