package elite.dangerous.model;

import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public class StoredShipHere
{
    private boolean hot;
    private String  name, shipType;
    private long    value;
    private int     shipID;
}
