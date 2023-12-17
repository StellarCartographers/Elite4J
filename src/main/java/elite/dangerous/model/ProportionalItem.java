package elite.dangerous.model;

import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public abstract class ProportionalItem
{
    private String name;
    public float   proportion;
}
