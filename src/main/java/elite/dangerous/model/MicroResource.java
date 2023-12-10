package elite.dangerous.model;

import elite.dangerous.model.enums.MicroResourceCategory;
import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT) public class MicroResource
{

    private String name;

    public MicroResourceCategory category;

    private int count;
}
