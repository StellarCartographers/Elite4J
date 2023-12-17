package elite.dangerous.model;

import lombok.EliteObject;

@EliteObject
public class Module
{
    private String     slot, item;
    private boolean    on;
    private int        priority, ammoInClip, ammoInHopper;
    private double     health, power;
    public Engineering engineering;
}
