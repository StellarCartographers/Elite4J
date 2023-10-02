package elite.dangerous.capi.modal.fleetcarrier;

import java.util.List;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Orders
{
    private Ledger commodities;
    private Ledger microResources;

    @Value
    @Builder
    @Jacksonized
    public static class Ledger
    {
        private List<Sales>    sales;
        private List<Purchase> purchases;
    }

    @Value
    @Builder
    @Jacksonized
    public static class Sales
    {
        private String  name;
        private int     stock;
        private int     price;
        private boolean blackmarket;
    }

    @Value
    @Builder
    @Jacksonized
    public static class Purchase
    {
        private String  name;
        private int     total;
        private int     outstanding;
        private int     price;
        private boolean blackmarket;
    }
}
