/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi.modal.fc;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.*;

import elite.dangerous.capi.modal.fc.Ships.FleetCarrierShipAdapter;
import elite.dangerous.model.identity.ID;

@EliteObject
@JsonDeserialize(using = FleetCarrierShipAdapter.class)
public class Ships
{
    private List<CarrierShip> shipyard_list;

    @EliteObject
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CarrierShip
    {
        @JsonProperty("id")
        private ID id;
        private String name;
        private int    baseValue;
        private String sku;

        public static CarrierShip fromJsonNode(JsonNode node)
        {
            var id = Objects.requireNonNull(node.get("id").asLong());
            var name = Objects.requireNonNull(node.get("name").asText());
            var baseValue = Objects.requireNonNull(node.get("basevalue").asInt());
            var sku = node.get("sku").isNull() ? null : node.get("sku").asText();
            return new CarrierShip(new ID(id), name, baseValue, sku);
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
