package elite.dangerous.journal.events.travel;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class DockingDenied extends Event
{

    private String reason;

    private String stationName;

    private String stationType;

    private long   marketID;

}
