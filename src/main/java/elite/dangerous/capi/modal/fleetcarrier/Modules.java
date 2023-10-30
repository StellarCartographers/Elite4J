package elite.dangerous.capi.modal.fleetcarrier;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import elite.dangerous.capi.modal.fleetcarrier.Modules.EliteModule;
import elite.dangerous.utils.adapter.FleetCarrierModuleAdapter;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@JsonDeserialize(using = FleetCarrierModuleAdapter.class)
public class Modules extends ArrayList<EliteModule>
{
    private static final long serialVersionUID = 8281161899721149806L;

    /**
     * @apiNote This should just be named Module but decided on EliteModule so we
     * don't run into any conflicts with {@link java.lang.Module}, since most 
     * IDE's will default to that class. For example, when passed as a generic type
     */
    @Data
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
