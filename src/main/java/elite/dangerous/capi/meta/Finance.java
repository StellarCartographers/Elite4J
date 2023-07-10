package elite.dangerous.capi.meta;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Finance {
    @SerializedName("bankBalance")
    private String balance;

    @SerializedName("bankReservedBalance")
    private String reservedBalance;

    @SerializedName("taxation")
    private String taxation;

    @SerializedName("service_taxation")
    private ServiceTaxation serviceTaxation;

    @SerializedName("numServices")
    private String servicesCount;

    @SerializedName("numOptionalServices")
    private String optionalServicesCount;

    @SerializedName("debtThreshold")
    private String debtThreshold;

    @SerializedName("maintenance")
    private String maintenance;

    @SerializedName("maintenanceToDate")
    private String maintenanceToDate;

    @SerializedName("coreCost")
    private String coreCost;

    @SerializedName("servicesCost")
    private String servicesCost;

    @SerializedName("servicesCostToDate")
    private String servicesCostToDate;

    @SerializedName("jumpsCost")
    private String jumpsCost;

    @SerializedName("numJumps")
    private String jumpCount;

    @SerializedName("bartender")
    private Bartender bartender;

    @Value
    @Builder
    public static class ServiceTaxation {
        @SerializedName("bartender")
        public String bartender;

        @SerializedName("pioneersupplies")
        public String pioneersupplies;

        @SerializedName("rearm")
        public String rearm;

        @SerializedName("refuel")
        public String refuel;

        @SerializedName("repair")
        public String repair;

        @SerializedName("shipyard")
        public String shipyard;

        @SerializedName("outfitting")
        public String outfitting;
    }

    @Value
    @Builder
    public static class Bartender {
        @SerializedName("microresourcesTotalValue")
        private String microresourcesTotalValue;

        @SerializedName("allTimeProfit")
        private String allTimeProfit;

        @SerializedName("microresourcesForSale")
        private String microresourcesForSale;

        @SerializedName("microresourcesPurchaseOrders")
        private String microresourcesPurchaseOrders;

        @SerializedName("balanceAllocForPurchaseOrders")
        private String balanceAllocForPurchaseOrders;

        @SerializedName("profitHistory")
        private List<Long> profitHistory;
    }
}
