package elite.dangerous.journal.events.exploration;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class FSSDiscoveryScan extends Event
{

    private String systemName;

    private long   systemAddress;

    private double progress;

    private int    bodyCount, nonBodyCount;

}
