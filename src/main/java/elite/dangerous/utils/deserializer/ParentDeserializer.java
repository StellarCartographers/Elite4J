package elite.dangerous.utils.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import elite.dangerous.models.scan.Parent;

import java.lang.reflect.Type;

public class ParentDeserializer implements JsonDeserializer<Parent> {

  @Override
  public Parent deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    Parent parent = null;

    JsonObject jsonParent = json.getAsJsonObject();
    for (String s : jsonParent.keySet()) {
      parent = new Parent(s, jsonParent.get(s).getAsInt());
      break;
    }

    return parent;
  }
}
