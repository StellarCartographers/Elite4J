package elite.dangerous.capi.modal.fc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import elite.dangerous.capi.modal.fc.Ships.FleetCarrierShipAdapter;
import elite.dangerous.fdev.FDevID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EliteObject;

@EliteObject
@JsonDeserialize(using = FleetCarrierShipAdapter.class)
public class Ships
{
    private List<CarrierShip> shipyard_list;

    @EliteObject
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CarrierShip
    {
        private FDevID id;
        private String name;
        private int    baseValue;
        private String sku;

        public static CarrierShip fromJsonNode(JsonNode node)
        {
            var id = Objects.requireNonNull(node.get("id").asLong());
            var name = Objects.requireNonNull(node.get("name").asText());
            var baseValue = Objects.requireNonNull(node.get("basevalue").asInt());
            var sku = node.get("sku").isNull() ? null : node.get("sku").asText();
            return new CarrierShip(new FDevID(id), name, baseValue, sku);
        }
    }
    
    @SuppressWarnings("serial")
    static class FleetCarrierShipAdapter extends StdDeserializer<Ships>
    {
        protected FleetCarrierShipAdapter()
        {
            super(Ships.class);
        }

        @Override
        public Ships deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException
        {
            JsonNode node = p.getCodec().readTree(p);
            var ships = new Ships();
            ships.shipyard_list = new ArrayList<Ships.CarrierShip>();
            
            JsonNode shipyardList = node.get("shipyard_list");
            
            if(shipyardList.properties().isEmpty()) {
                return ships;
            }
            
            shipyardList.properties().forEach(e -> {
                ships.shipyard_list.add(CarrierShip.fromJsonNode(e.getValue()));
            });
            
            return ships;
        }
    }
}
