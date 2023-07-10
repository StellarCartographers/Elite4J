package elite.dangerous.capi.meta;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Orders {
    private Ledger commodities, microResources;

    @Value
    @Builder
    public static class Ledger {
        private List<Sales> sales;

        private List<Purchase> purchases;
    }

    @Value
    @Builder
    public static class Sales {
        private String name, stock, price;

        private boolean blackmarket;
    }

    @Value
    @Builder
    public static class Purchase {
        private String name, locName, total, outstanding, price;
    }
}
