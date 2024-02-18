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

import elite.dangerous.capi.modal.fc.Modules.*;
import elite.dangerous.model.identity.ID;

@SuppressWarnings("serial")
@JsonDeserialize(using = DeserializeAdapter.class)
public class Modules extends ArrayList<CarrierModule>
{
    @EliteObject
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CarrierModule
    {
        @JsonProperty("id")
        private ID id;
        private String category;
        private String name;
        private int    cost;
        private String sku;
        private int    stock;

        public static CarrierModule fromJsonNode(JsonNode node)
        {
            var id = Objects.requireNonNull(new ID(node.get("id").asLong()), "node field 'id' cannot be null");
            var category = Objects.requireNonNull(node.get("category").asText(), "node field 'category' cannot be null");
            var name = Objects.requireNonNull(node.get("name").asText(), "node field 'name' cannot be null");
            var cost = Objects.requireNonNull(node.get("cost").asInt(), "node field 'cost' cannot be null");
            var sku = node.get("sku").isNull() ? null : node.get("sku").asText();
            var stock = Objects.requireNonNull(node.get("stock").asInt(), "node field 'stock' cannot be null");
            return new CarrierModule(id, category, name, cost, sku, stock);
        }
    }

    static class DeserializeAdapter extends StdDeserializer<Modules>
    {
        protected DeserializeAdapter()
        {
            super(Modules.class);
        }

        @Override
        public Modules deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException
        {
            JsonNode node = p.getCodec().readTree(p);
            var modules = new Modules();

            if (node.properties().isEmpty())
            {
                return modules;
            }

            node.properties().forEach(e ->
            {
                modules.add(CarrierModule.fromJsonNode(e.getValue()));
            });

            return modules;
        }
    }
}
