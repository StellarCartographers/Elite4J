package elite.dangerous.capi.modal.fleetcarrier;

import java.util.List;
import java.util.function.Predicate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class Orders
{
    private CommodityLedger commodities;
    @JsonProperty("onfootmicroresources")
    private MicroResourceLedger microResources;

    @Getter
    @Builder
    @Jacksonized
    public static class CommodityLedger
    {
        private List<CommoditySale>    sales;
        private List<CommodityPurchase> purchases;
        
        @JsonIgnore
        public boolean isSelling()
        {
            return !sales.isEmpty();
        }
        
        @JsonIgnore
        public boolean isBuying()
        {
            return !purchases.isEmpty();
        }
        
        @Getter
        @Builder
        @Jacksonized
        public static class CommoditySale implements Sale
        {
            private String  name;
            private int     stock;
            private int     price;
            private boolean blackmarket;
            
            @JsonIgnore
            public static Legality<CommoditySale> Legality()
            {
                return sale -> sale.isBlackmarket();
            }
        }

        @Getter
        @Builder
        @Jacksonized
        public static class CommodityPurchase implements Purchase
        {
            private String  name;
            private int     total;
            private int     outstanding;
            private int     price;
            private boolean blackmarket;
            
            @JsonIgnore
            public static Legality<CommodityPurchase> Legality()
            {
                return purchase -> purchase.isBlackmarket();
            }
        }
        
        @FunctionalInterface
        public interface Legality<T>
        {
            boolean isIllegal(T t);
            
            default Predicate<T> asPredicate() {
                return t -> isIllegal(t);
            }
        }
    }
    
    @Getter
    @Builder
    @Jacksonized
    public static class MicroResourceLedger
    {
        private List<MicroResourceSale>    sales;
        private List<MicroResourcePurchase> purchases;
        
        @JsonIgnore
        public boolean isSelling()
        {
            return !sales.isEmpty();
        }
        
        @JsonIgnore
        public boolean isBuying()
        {
            return !purchases.isEmpty();
        }
        
        @Getter
        @Builder
        @Jacksonized
        public static class MicroResourceSale implements Sale
        {
            private String  name;
            private String  locName;
            private int     stock;
            private int     price;
        }

        @Getter
        @Builder
        @Jacksonized
        public static class MicroResourcePurchase implements Purchase
        {
            private String  name;
            private String  locName;
            private int     total;
            private int     outstanding;
            private int     price;
        }
    }
    
    public interface Sale {
        String getName();
        int getStock();
        int getPrice();
    }
    
    public interface Purchase {
        String getName();
        int getTotal();
        int getOutstanding();
        int getPrice();
    }
}
