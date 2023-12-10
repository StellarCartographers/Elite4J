package elite.dangerous.journal.events.travel;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ApproachBody extends Event
{

    private String starSystem;

    private String body;

    private int    bodyID;

    private long   systemAddress;

}
