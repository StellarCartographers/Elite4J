package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class RefuelAll extends Event
{

    private long   cost;

    private double amount;

}
