package elite.dangerous.journal.events.exploration;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.journal.models.scan.Ring;

public class Scan extends Event
{

    public String scanType;

    public String bodyName;

    public int bodyID;

    public String starSystem;

    public double distanceFromArrivalLS;

    public double rotationPeriod;

    public double surfaceTemperature;

    public List<Ring> rings;

    public long semiMajorAxis;

    public double eccentricity;

    public double orbitalInclination;

    public double periapsis;

    public long orbitalPeriod;

    public boolean wasDiscovered;

    public boolean wasMapped;

}
