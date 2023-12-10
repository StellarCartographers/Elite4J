package elite.dangerous.journal.events.trade;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CollectCargo extends Event
{

    private String  type;

    private long    missionID;

    private boolean stolen;

}
