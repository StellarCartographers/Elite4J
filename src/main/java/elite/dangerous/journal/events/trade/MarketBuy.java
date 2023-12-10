package elite.dangerous.journal.events.trade;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class MarketBuy extends Event
{

    private long   marketID;

    private String type;

    private int    count;

    private int    buyPrice;

    private int    totalCost;

}
