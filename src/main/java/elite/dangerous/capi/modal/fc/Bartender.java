package elite.dangerous.capi.modal.fc;

import java.util.List;

import lombok.EliteObject;

@EliteObject
public class Bartender
{
    private long       microresourcesTotalValue;
    private long       allTimeProfit;
    private long       microresourcesForSale;
    private long       microresourcesPurchaseOrders;
    private long       balanceAllocForPurchaseOrders;
    private List<Long> profitHistory;
}