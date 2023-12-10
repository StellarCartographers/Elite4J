package elite.dangerous.journal.events.trade;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class MarketSell extends Event
{

    private long    marketID;

    private String  type;

    private int     count;

    private int     sellPrice;

    private int     totalSale;

    private int     avgPricePaid;

    private boolean illegalGoods;

    private boolean stolenGoods;

    private boolean blackMarket;

}
