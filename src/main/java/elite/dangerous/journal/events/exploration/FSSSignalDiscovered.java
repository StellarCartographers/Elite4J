package elite.dangerous.journal.events.exploration;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class FSSSignalDiscovered extends Event
{

    private String  signalName;

    private String  ussType;

    private String  spawningState;

    private String  spawningFaction;

    private int     threatLevel;

    private long    systemAddress;

    private double  timeRemaining;

    private boolean isStation;

}
