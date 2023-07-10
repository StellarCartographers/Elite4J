package elite.dangerous.utils.deserializer;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import elite.dangerous.base.Bounty;
import elite.dangerous.events.combat.BountyDefault;
import elite.dangerous.events.combat.BountySkimmer;

public class BountyEventDeserializer implements JsonDeserializer<Bounty> {

  @Override
  public Bounty deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    Bounty event;

    JsonObject jsonEvent = json.getAsJsonObject();
    if (jsonEvent.has("Target") && jsonEvent.get("Target").getAsString().equals("Skimmer")) {
      event = context.deserialize(json, BountySkimmer.class);
    } else {
      event = context.deserialize(json, BountyDefault.class);
    }

    return event;
  }
}
