package elite.dangerous.utils.deserializer;

import java.lang.reflect.Type;
import java.util.Map.Entry;
import java.util.function.Function;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import elite.dangerous.capi.modal.fleetcarrier.Modules;
import elite.dangerous.capi.modal.fleetcarrier.Modules.EliteModule;

public class ModulesDeserializer implements JsonDeserializer<Modules> {
    private Function<JsonElement, EliteModule> toModule;

    @Override
    public Modules deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        toModule = e -> context.deserialize(e, EliteModule.class);
        var set = json.getAsJsonObject().entrySet().stream().map(Entry::getValue);
        return Modules.Instantiator().modules(set.map(e -> toModule.apply(e)).toList()).newInstance();
    }
}
