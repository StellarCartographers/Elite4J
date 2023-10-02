package elite.dangerous.capi.modal.fleetcarrier;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import elite.dangerous.utils.adapter.CarrierModuleAdapter;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder(builderMethodName = "Instantiator", buildMethodName = "newInstance")
@JsonDeserialize(using = CarrierModuleAdapter.class)
public class Modules
{
    @Singular
    private List<EliteModule> modules;

    /**
     * @apiNote This should just be named Module but decided on EliteModule so we
     * don't run into any conflicts with {@link java.lang.Module}, since most 
     * IDE's will default to that class. For example, when passed as a generic type
     */
    @Value
    @Builder(builderMethodName = "Instantiator", buildMethodName = "newInstance")
    @Jacksonized
    public static class EliteModule
    {
        private int id;
        private String category;
        private String name;
        private int cost;
        private String sku;
        private int stock;
    }
}
