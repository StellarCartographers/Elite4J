package elite.dangerous.model.material;

import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public abstract class Item
{
    private String name;
    private int    count;
}
