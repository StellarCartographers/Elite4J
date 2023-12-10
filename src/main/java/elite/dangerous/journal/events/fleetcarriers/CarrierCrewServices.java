package elite.dangerous.journal.events.fleetcarriers;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CarrierCrewServices extends Event
{

    private String crewName, crewRole, operation;

    private long   carrierID;

}
