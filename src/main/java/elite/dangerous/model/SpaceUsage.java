package elite.dangerous.model;

import lombok.EliteObject;

@EliteObject
public class SpaceUsage
{
    private int totalCapacity;
    private int crew;
    private int cargo;
    private int cargoSpaceReserved;
    private int shipPacks;
    private int modulePacks;
    private int freeSpace;
}
