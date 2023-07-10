package elite.dangerous.utils.deserializer;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import elite.dangerous.events.combat.Died;
import elite.dangerous.events.combat.DiedByPVP;
import elite.dangerous.events.combat.DiedByWing;

public class DiedEventDeserializer implements JsonDeserializer<Died> {

  @Override
  public Died deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    Died event;

    JsonObject jsonEvent = json.getAsJsonObject();
    if(jsonEvent.has("KillerShip"))
    {
    	event = context.deserialize(json, DiedByPVP.class);
    } else if(jsonEvent.has("Killers")) {
    	event = context.deserialize(json, DiedByWing.class);
    } else {
		event = context.deserialize(json, Died.class);
	}

    return event;
  }
}
