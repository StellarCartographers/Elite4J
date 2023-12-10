package elite.dangerous.journal.events.fleetcarriers;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CarrierNameChanged extends Event
{

    private long   carrierID;

    private String callsign;

    private String name;

}
