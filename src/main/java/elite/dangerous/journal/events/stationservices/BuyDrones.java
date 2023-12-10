package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class BuyDrones extends Event
{
    private String type;

    private int    count;

    private int    buyPrice;

    private int    totalCost;

}
