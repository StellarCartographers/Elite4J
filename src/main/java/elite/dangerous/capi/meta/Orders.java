package elite.dangerous.capi.meta;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Orders
{
    @SerializedName("commodities")
    private Ledger commodities;
    @SerializedName("microResources")
    private Ledger microResources;

    @Value
    @Builder
    @Jacksonized
    public static class Ledger
    {
        @SerializedName("sales")
        private List<Sales>    sales;
        @SerializedName("purchases")
        private List<Purchase> purchases;
    }

    @Value
    @Builder
    @Jacksonized
    public static class Sales
    {
        @SerializedName("name")
        private String  name;
        @SerializedName("stock")
        private int     stock;
        @SerializedName("price")
        private int     price;
        @SerializedName("blackmarket")
        private boolean blackmarket;
    }

    @Value
    @Builder
    @Jacksonized
    public static class Purchase
    {
        @SerializedName("name")
        private String  name;
        @SerializedName("total")
        private int     total;
        @SerializedName("outstanding")
        private int     outstanding;
        @SerializedName("price")
        private int     price;
        @SerializedName("blackmarket")
        private boolean blackmarket;
    }
}
