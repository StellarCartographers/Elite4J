package elite.dangerous.journal.events.trade;

import elite.dangerous.journal.base.Event;

public class MarketBuy extends Event
{

    public long marketID;

    public String type;

    public int count;

    public int buyPrice;

    public int totalCost;

}
