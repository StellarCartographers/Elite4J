package elite.dangerous.capi.modal.fc;

import lombok.EliteObject;

@EliteObject
public class Finances
{
    private long cargoTotalValue;
    private long allTimeProfit;
    private int  numCommodsForSale;
    private int  numCommodsPurchaseOrders;
    private long balanceAllocForPurchaseOrders;
}
