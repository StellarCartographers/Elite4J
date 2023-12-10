package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class RefuelPartial extends Event
{

    private int    cost;

    private double amount;

}
