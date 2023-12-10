package elite.dangerous.journal.events.exploration;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ScanBaryCentre extends Event
{

    private int    bodyID;

    private String starSystem;

    private long   systemAddress;

    private double semiMajorAxis;

    private double eccentricity;

    private double orbitalInclination;

    private double periapsis;

    private double orbitalPeriod;

    private double ascendingNode;

    private double meanAnomaly;

}
