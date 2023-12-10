package elite.dangerous.journal.events.travel;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class SupercruiseDestinationDrop extends Event
{
    private String type;

    private int    threat;

    private long   marketID;
}
