package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CommunityGoalJoin extends Event
{
    private int    cgid;

    private String name;

    private String system;
}
