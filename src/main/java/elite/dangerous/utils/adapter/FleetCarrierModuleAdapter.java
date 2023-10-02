//package elite.dangerous.utils.deserializer;
//
//import java.lang.reflect.Type;
//import java.util.Map.Entry;
//import java.util.function.Function;
//
//import com.google.gson.JsonDeserializationContext;
//import com.google.gson.JsonDeserializer;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParseException;
//
//import elite.dangerous.capi.modal.fleetcarrier.Modules;
//import elite.dangerous.capi.modal.fleetcarrier.Modules.EliteModule;
//
//public class ModulesDeserializer implements JsonDeserializer<Modules> {
//    private Function<JsonElement, EliteModule> toModule;
//
//    @Override
//    public Modules deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//        toModule = e -> context.deserialize(e, EliteModule.class);
//        var set = json.getAsJsonObject().entrySet().stream().map(Entry::getValue);
//        return Modules.Instantiator().modules(set.map(e -> toModule.apply(e)).toList()).newInstance();
//    }
//}

package elite.dangerous.utils.adapter;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import elite.dangerous.capi.modal.fleetcarrier.Modules;
import elite.dangerous.capi.modal.fleetcarrier.Modules.EliteModule;

public class FleetCarrierModuleAdapter extends StdDeserializer<Modules>
{
    private static final long serialVersionUID = -3709038638410018106L;

    protected FleetCarrierModuleAdapter()
    {
        super(Modules.class);
    }

    @Override
    public Modules deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException
    {
        JsonNode node = p.getCodec().readTree(p);
        var modules = Modules.Instantiator();
        node.properties().forEach(e -> {
            var n = e.getValue();
            var em = EliteModule.Instantiator()
                .id(n.get("id").asInt())
                .category(n.get("category").asText())
                .name(n.get("name").asText())
                .cost(n.get("cost").asInt())
                .sku(n.get("sku").isNull() ? null : n.get("sku").asText())
                .stock(n.get("stock").asInt());
            modules.module(em.newInstance());
        });
        
        return modules.newInstance();
    }
}
