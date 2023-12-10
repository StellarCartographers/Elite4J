package elite.dangerous.journal.events.travel;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class FSDTarget extends Event
{

    private String name;

    private String starClass;

    private long   systemAddress;

    private int    remainingJumpsInRoute;

}
