package elite.dangerous.journal.events.exploration;

import elite.dangerous.journal.base.Event;

public class FSSDiscoveryScan extends Event
{

    public String systemName;

    public long systemAddress;

    public double progress;

    public int bodyCount, nonBodyCount;

}
