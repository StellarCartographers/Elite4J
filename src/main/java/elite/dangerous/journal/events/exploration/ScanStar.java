package elite.dangerous.journal.events.exploration;

import lombok.EliteObject;

@EliteObject
public class ScanStar extends Scan
{

    private String  starType;

    private String  luminosity;

    private long    systemAddress;

    private double  stellarMass;

    private long    radius;

    private double  absoluteMagnitude;

    private long    ageMY;

    private boolean wasMapped;

    private boolean wasDiscovered;

}
