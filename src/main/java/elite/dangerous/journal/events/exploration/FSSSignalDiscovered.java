package elite.dangerous.journal.events.exploration;

import elite.dangerous.journal.base.Event;

public class FSSSignalDiscovered extends Event
{

    public String signalName;

    public String ussType;

    public String spawningState;

    public String spawningFaction;

    public int threatLevel;

    public long systemAddress;

    public double timeRemaining;

    public boolean isStation;

}
