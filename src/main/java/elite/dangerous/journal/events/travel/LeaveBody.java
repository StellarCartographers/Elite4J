package elite.dangerous.journal.events.travel;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class LeaveBody extends Event
{

    private String starSystem, body;

    private long   systemAddress;

    private int    bodyID;

}
