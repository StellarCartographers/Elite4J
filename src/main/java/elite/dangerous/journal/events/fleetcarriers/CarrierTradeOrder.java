package elite.dangerous.journal.events.fleetcarriers;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CarrierTradeOrder extends Event
{

    private long    carrierID;

    private boolean blackMarket;

    private String  commodity;

    private int     purchaseOrder;

    private int     saleOrder;

    private boolean cancelTrade;

    private int     price;

}
