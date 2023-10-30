package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;

public class MissionCompleted extends Event
{

    public String faction;

    public String name;

    public String targetFaction;

    public String destinationSystem;

    public String destinationStation;

    public long missionID;

    public long reward;

}
