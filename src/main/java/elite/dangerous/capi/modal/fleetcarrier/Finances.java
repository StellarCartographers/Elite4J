package elite.dangerous.capi.modal.fleetcarrier;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Finances
{
    private long cargoTotalValue;
    private long allTimeProfit;
    private int  numCommodsForSale;
    private int  numCommodsPurchaseOrders;
    private long balanceAllocForPurchaseOrders;
}
