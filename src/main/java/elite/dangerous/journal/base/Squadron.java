package elite.dangerous.journal.base;

import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public abstract class Squadron extends Event
{
    private String squadronName;
}
