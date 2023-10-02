package elite.dangerous.journal.events.trade;

import elite.dangerous.journal.Event;

public class MarketBuy extends Event
{

    public long marketID;

    public String type;

    public String typeLocalised;

    public int count;

    public int buyPrice;

    public int totalCost;

}
