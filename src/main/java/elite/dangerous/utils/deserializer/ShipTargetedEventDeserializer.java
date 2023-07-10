package elite.dangerous.utils.deserializer;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import elite.dangerous.events.combat.ShipTargeted;
import elite.dangerous.events.combat.ShipTargetedStage0;
import elite.dangerous.events.combat.ShipTargetedStage1;
import elite.dangerous.events.combat.ShipTargetedStage2;
import elite.dangerous.events.combat.ShipTargetedStage3;

public class ShipTargetedEventDeserializer implements JsonDeserializer<ShipTargeted>
{

    @Override
    public ShipTargeted deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        ShipTargeted event = null;

        JsonObject jsonEvent    = json.getAsJsonObject();
        boolean    targetLocked = jsonEvent.get("TargetLocked").getAsBoolean();
        if (!targetLocked)
        {
            event = context.deserialize(json, ShipTargeted.class);
        } else
        {
            int scanStage = jsonEvent.get("ScanStage").getAsInt();
            switch (scanStage)
            {
                case 0:
                    event = context.deserialize(json, ShipTargetedStage0.class);
                    break;

                case 1:
                    event = context.deserialize(json, ShipTargetedStage1.class);
                    break;

                case 2:
                    event = context.deserialize(json, ShipTargetedStage2.class);
                    break;

                case 3:
                    event = context.deserialize(json, ShipTargetedStage3.class);
                    break;
            }
        }

        return event;
    }
}
