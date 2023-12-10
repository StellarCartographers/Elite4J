package elite.dangerous.journal.events.exploration;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class DiscoveryScan extends Event
{
    private long systemAddress;

    private int  bodies;

}
