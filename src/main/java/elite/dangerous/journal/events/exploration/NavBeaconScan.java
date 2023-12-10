package elite.dangerous.journal.events.exploration;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class NavBeaconScan extends Event
{

    private long systemAddress;

    private int  numBodies;

}
