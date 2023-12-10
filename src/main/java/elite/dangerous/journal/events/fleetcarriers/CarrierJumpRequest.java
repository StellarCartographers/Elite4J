package elite.dangerous.journal.events.fleetcarriers;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CarrierJumpRequest extends Event
{

    private long   carrierID;

    private String systemName;

    private String body;

    private long   systemAddress;

    private int    bodyID;

    private String departureTime;

}
