package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ScientificResearch extends Event
{

    private int    marketID;

    private String name;

    private String category;

    private int    count;

}
