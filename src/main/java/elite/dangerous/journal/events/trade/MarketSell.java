package elite.dangerous.journal.events.trade;

import elite.dangerous.journal.Event;

public class MarketSell extends Event
{

    public long marketID;

    public String type;

    public String typeLocalised;

    public int count;

    public int sellPrice;

    public int totalSale;

    public int avgPricePaid;

    public boolean illegalGoods;

    public boolean stolenGoods;

    public boolean blackMarket;

}
