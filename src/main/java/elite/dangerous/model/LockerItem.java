package elite.dangerous.model;

import elite.dangerous.model.material.Item;
import lombok.EliteObject;

@EliteObject
public class LockerItem extends Item
{

    private long ownerID;

    private long missionID;
}