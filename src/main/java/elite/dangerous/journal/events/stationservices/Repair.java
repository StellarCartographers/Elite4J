package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class Repair extends Event
{

    private String item;

    private long   cost;

}
