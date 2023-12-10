package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class Outfitting extends Event
{

    private long   marketID;

    private String stationName, starSystem;
}
