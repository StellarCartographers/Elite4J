package elite.dangerous.utils.adapter;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import elite.dangerous.capi.modal.fleetcarrier.Ships;
import elite.dangerous.capi.modal.fleetcarrier.Ships.EliteShip;

public class FleetCarrierShipAdapter extends StdDeserializer<Ships>
{
    private static final long serialVersionUID = -6418600411156237217L;

    protected FleetCarrierShipAdapter()
    {
        super(Ships.class);
    }

    @Override
    public Ships deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException
    {
        JsonNode node = p.getCodec().readTree(p);
        var ships = new Ships();
        
        JsonNode shipyardList = node.get("shipyard_list");
        
        if(shipyardList.properties().isEmpty()) {
            return ships;
        }
        
        var shipyard = ships.getShipyard_list();
        shipyardList.properties().forEach(e -> {
            var n = e.getValue();
            var em = EliteShip.Instantiator()
                .id(n.get("id").asInt())
                .name(n.get("name").asText())
                .baseValue(n.get("basevalue").asInt())
                .sku(n.get("sku").isNull() ? null : n.get("sku").asText());
            shipyard.add(em.newInstance());
        });
        
        return ships;
    }
}
