package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class SearchAndRescue extends Event
{

    private long   marketID, reward;

    private String name;

    private int    count;

}
