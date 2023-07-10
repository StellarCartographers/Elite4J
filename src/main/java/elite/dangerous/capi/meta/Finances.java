package elite.dangerous.capi.meta;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Finances {
    @SerializedName("cargoTotalValue")
    private String cargoTotalValue;

    @SerializedName("allTimeProfit")
    private String allTimeProfit;

    @SerializedName("numCommodsForSale")
    private String numCommodsForSale;

    @SerializedName("numCommodsPurchaseOrders")
    private String numCommodsPurchaseOrders;

    @SerializedName("balanceAllocForPurchaseOrders")
    private String balanceAllocForPurchaseOrders;
}
