package elite.dangerous.journal.events.fleetcarriers;

import elite.dangerous.journal.Event;

public class CarrierTradeOrder extends Event
{

    public long carrierID;

    public boolean blackMarket;

    public String commodity;

    public int purchaseOrder;

    public int saleOrder;

    public boolean cancelTrade;

    public int price;

}
