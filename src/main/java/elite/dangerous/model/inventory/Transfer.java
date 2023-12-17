package elite.dangerous.model.inventory;

import lombok.EliteObject;

@EliteObject
public class Transfer
{
    private String type, direction;
    private int    count;
}
