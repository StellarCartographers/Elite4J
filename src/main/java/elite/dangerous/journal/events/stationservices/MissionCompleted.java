package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class MissionCompleted extends Event
{

    private String faction;

    private String name;

    private String targetFaction;

    private String destinationSystem;

    private String destinationStation;

    private long   missionID;

    private long   reward;

}
