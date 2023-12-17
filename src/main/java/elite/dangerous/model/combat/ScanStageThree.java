package elite.dangerous.model.combat;

import lombok.EliteObject;

@EliteObject
public class ScanStageThree extends ScanStageTwo
{
    private String faction;
    private String legalStatus;
    private String subsystem;
    private double subsystemHealth;
    private String power;
    private long   bounty;
}
