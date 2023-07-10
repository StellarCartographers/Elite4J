package elite.dangerous.utils.deserializer;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import elite.dangerous.events.exploration.Scan;
import elite.dangerous.events.exploration.ScanPlanetOrMoon;
import elite.dangerous.events.exploration.ScanStar;

public class ScanEventDeserializer implements JsonDeserializer<Scan> {

  @Override
  public Scan deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    Scan event;

    JsonObject jsonEvent = json.getAsJsonObject();
    if (jsonEvent.has("StarType")) {
      event = context.deserialize(json, ScanStar.class);
    } else {
      event = context.deserialize(json, ScanPlanetOrMoon.class);
    }

    return event;
  }
}
