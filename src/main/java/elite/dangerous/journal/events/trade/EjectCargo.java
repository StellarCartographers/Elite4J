package elite.dangerous.journal.events.trade;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class EjectCargo extends Event
{

    private String  type;

    private String  powerplayOrigin;

    private int     count;

    private long    missionID;

    private boolean abandoned;

}
