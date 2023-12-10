package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CrewAssign extends Event
{

    private String name;

    private String role;

    private int    crewID;

}
