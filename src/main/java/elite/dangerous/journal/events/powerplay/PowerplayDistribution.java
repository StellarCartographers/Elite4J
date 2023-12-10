package elite.dangerous.journal.events.powerplay;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public abstract class PowerplayDistribution extends Event
{

    private String power;

    private String type;

    private int    count;
}
