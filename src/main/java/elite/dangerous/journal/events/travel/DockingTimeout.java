package elite.dangerous.journal.events.travel;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class DockingTimeout extends Event
{

    private String stationName;

    private String stationType;

    private long   marketID;

}
