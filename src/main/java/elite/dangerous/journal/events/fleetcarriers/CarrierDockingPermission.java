package elite.dangerous.journal.events.fleetcarriers;

import elite.dangerous.journal.base.Event;

public class CarrierDockingPermission extends Event
{

    public long carrierID;

    public String dockingAccess;

    public boolean allowNotorious;

}
