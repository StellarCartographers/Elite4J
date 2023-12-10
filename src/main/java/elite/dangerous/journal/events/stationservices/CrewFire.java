package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CrewFire extends Event
{

    private String name;

    private int    crewID;

}
