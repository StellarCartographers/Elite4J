package elite.dangerous.model.combat;

import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public class ScanStageTwo extends ScanStageOne
{
    private double shieldHealth;
    private double hullHealth;
}
