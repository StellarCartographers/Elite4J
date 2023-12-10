package elite.dangerous.journal.events.combat;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public abstract class ShipTargeted extends Event
{
    private boolean targetLocked;
}
