package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class SellDrones extends Event
{

    private String type;

    private int    count;

    private long   sellPrice, totalSale;

}
