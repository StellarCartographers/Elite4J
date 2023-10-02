package elite.dangerous.journal.events.stationservices;

import java.util.Date;

import elite.dangerous.journal.Event;

public class MissionAccepted extends Event
{

    public String faction;

    public String name;

    public String localisedName;

    public String targetFaction;

    public String destinationSystem;

    public String destinationStation;

    public String influence;

    public String reputation;

    public long reward;

    public long missionID;

    public Date expiry;

}
