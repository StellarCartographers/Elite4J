package elite.dangerous.journal.base;

import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public abstract class Dock extends Event
{
    private int id;
}
