package elite.dangerous.journal.events.stationservices;

import java.util.Date;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class MissionAccepted extends Event
{

    private String faction;

    private String name;

    private String localisedName;

    private String targetFaction;

    private String destinationSystem;

    private String destinationStation;

    private String influence;

    private String reputation;

    private long   reward;

    private long   missionID;

    public Date    expiry;

}
