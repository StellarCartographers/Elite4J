package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;

public class MissionRedirected extends Event
{

    public String name;

    public String newDestinationStation;

    public String newDestinationSystem;

    public String oldDestinationStation;

    public String oldDestinationSystem;

    public long missionID;

}
