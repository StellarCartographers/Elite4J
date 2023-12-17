package elite.dangerous.model.combat;

import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public class ScanStageOne extends ShipTargetLocked
{
    private String pilotName;
    private String pilotRank;
}
