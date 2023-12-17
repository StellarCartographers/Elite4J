package elite.dangerous.model;

import lombok.EliteObject;

@EliteObject
public class CargoItem
{
    private String name;
    private int    count, missionID, stolen;
}
