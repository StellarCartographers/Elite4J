package elite.dangerous.journal.events.travel;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class Undocked extends Event
{

    private String stationName, stationType;

    private long   marketID;

}
