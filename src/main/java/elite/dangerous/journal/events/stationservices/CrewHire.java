package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CrewHire extends Event
{

    private String name;

    private String faction;

    private int    crewID;

    private int    cost;

    private int    combatRank;

}
