package elite.dangerous.journal.base;

import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public abstract class Book extends Event
{
    private int     cost;

    private String  destinationSystem;

    private String  destinationLocation;

    private boolean retreat;
}
