package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class MissionAbandoned extends Event
{

    private String name;

    private long   missionID;

}
