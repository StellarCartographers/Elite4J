package elite.dangerous.capi.modal.fleetcarrier;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Finance
{
    private long            balance;
    private long            reservedBalance;
    private long            taxation;
    @JsonProperty("service_taxation")
    private ServiceTaxation serviceTaxation;
    private int             servicesCount;
    private long            optionalServicesCount;
    private long            debtThreshold;
    private long            maintenance;
    private long            maintenanceToDate;
    private long            coreCost;
    private long            servicesCost;
    private long            servicesCostToDate;
    private int             jumpsCost;
    private int             jumpCount;
    private Bartender       bartender;

    @Data
    @Builder
    @Jacksonized
    public static class ServiceTaxation
    {
        public int bartender;
        public int pioneersupplies;
        public int rearm;
        public int refuel;
        public int repair;
        public int shipyard;
        public int outfitting;
    }

    @Data
    @Builder
    @Jacksonized
    public static class Bartender
    {
        private long       microresourcesTotalValue;
        private long       allTimeProfit;
        private long       microresourcesForSale;
        private long       microresourcesPurchaseOrders;
        private long       balanceAllocForPurchaseOrders;
        private List<Long> profitHistory;
    }
}
