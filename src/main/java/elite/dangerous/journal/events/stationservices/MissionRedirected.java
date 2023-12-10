package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class MissionRedirected extends Event
{

    private String name;

    private String newDestinationStation;

    private String newDestinationSystem;

    private String oldDestinationStation;

    private String oldDestinationSystem;

    private long   missionID;

}
