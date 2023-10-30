package elite.dangerous.capi.modal.fleetcarrier;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import elite.dangerous.utils.adapter.FleetCarrierShipAdapter;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@JsonDeserialize(using = FleetCarrierShipAdapter.class)
@Getter
public class Ships
{
    private List<EliteShip> shipyard_list = new ArrayList<>();

    @Data
    @Builder(builderMethodName = "Instantiator", buildMethodName = "newInstance")
    @Jacksonized
    public static class EliteShip
    {
        private int id;
        private String name;
        private int    baseValue;
        private String sku;
    }
}
