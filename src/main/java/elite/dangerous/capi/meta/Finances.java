package elite.dangerous.capi.meta;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Finances
{
    @SerializedName("cargoTotalValue")
    private long cargoTotalValue;
    @SerializedName("allTimeProfit")
    private long allTimeProfit;
    @SerializedName("numCommodsForSale")
    private int  numCommodsForSale;
    @SerializedName("numCommodsPurchaseOrders")
    private int  numCommodsPurchaseOrders;
    @SerializedName("balanceAllocForPurchaseOrders")
    private long balanceAllocForPurchaseOrders;
}
