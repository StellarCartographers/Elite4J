package elite.dangerous.journal.events.fleetcarriers;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CarrierDockingPermission extends Event
{

    private long    carrierID;

    private String  dockingAccess;

    private boolean allowNotorious;

}
