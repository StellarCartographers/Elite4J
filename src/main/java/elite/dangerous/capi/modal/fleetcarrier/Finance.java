package elite.dangerous.capi.modal.fleetcarrier;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Finance
{
    @SerializedName("bankBalance")
    private long            balance;
    @SerializedName("bankReservedBalance")
    private long            reservedBalance;
    @SerializedName("taxation")
    private long            taxation;
    @SerializedName("service_taxation")
    private ServiceTaxation serviceTaxation;
    @SerializedName("numServices")
    private int             servicesCount;
    @SerializedName("numOptionalServices")
    private long            optionalServicesCount;
    @SerializedName("debtThreshold")
    private long            debtThreshold;
    @SerializedName("maintenance")
    private long            maintenance;
    @SerializedName("maintenanceToDate")
    private long            maintenanceToDate;
    @SerializedName("coreCost")
    private long            coreCost;
    @SerializedName("servicesCost")
    private long            servicesCost;
    @SerializedName("servicesCostToDate")
    private long            servicesCostToDate;
    @SerializedName("jumpsCost")
    private int             jumpsCost;
    @SerializedName("numJumps")
    private int             jumpCount;
    @SerializedName("bartender")
    private Bartender       bartender;

    @Value
    @Builder
    @Jacksonized
    public static class ServiceTaxation
    {
        @SerializedName("bartender")
        public int bartender;
        @SerializedName("pioneersupplies")
        public int pioneersupplies;
        @SerializedName("rearm")
        public int rearm;
        @SerializedName("refuel")
        public int refuel;
        @SerializedName("repair")
        public int repair;
        @SerializedName("shipyard")
        public int shipyard;
        @SerializedName("outfitting")
        public int outfitting;
    }

    @Value
    @Builder
    @Jacksonized
    public static class Bartender
    {
        @SerializedName("microresourcesTotalValue")
        private long       microresourcesTotalValue;
        @SerializedName("allTimeProfit")
        private long       allTimeProfit;
        @SerializedName("microresourcesForSale")
        private long       microresourcesForSale;
        @SerializedName("microresourcesPurchaseOrders")
        private long       microresourcesPurchaseOrders;
        @SerializedName("balanceAllocForPurchaseOrders")
        private long       balanceAllocForPurchaseOrders;
        @SerializedName("profitHistory")
        private List<Long> profitHistory;
    }
}
