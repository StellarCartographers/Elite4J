package elite.dangerous.capi.meta;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

@Value
@Builder(builderMethodName = "Instantiator", buildMethodName = "newInstance")
public class Modules {
    @Singular
    private List<EliteModule> modules;

    /**
     * @apiNote This should just be named Module but decided on EliteModule so we
     * don't run into any conflicts with {@link java.lang.Module}, since most 
     * IDE's will default to that class. For example, when passed as a generic type
     */
    @Value
    @Builder(builderMethodName = "Instantiator", buildMethodName = "newInstance")
    public static class EliteModule {
        @SerializedName("id")
        private String id;

        @SerializedName("category")
        private String category;

        @SerializedName("name")
        private String name;

        @SerializedName("cost")
        private String cost;

        @SerializedName("sku")
        private String sku;

        @SerializedName("stock")
        private String stock;
    }
}
