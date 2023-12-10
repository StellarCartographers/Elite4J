package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CommunityGoalReward extends Event
{
    private int    cgid;

    private int    reward;

    private String name;

    private String system;
}
