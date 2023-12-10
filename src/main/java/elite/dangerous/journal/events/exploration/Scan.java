package elite.dangerous.journal.events.exploration;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.scan.Ring;
import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public class Scan extends Event
{

    private String     scanType;

    private String     bodyName;

    private int        bodyID;

    private String     starSystem;

    private double     distanceFromArrivalLS;

    private double     rotationPeriod;

    private double     surfaceTemperature;

    private List<Ring> rings;

    private long       semiMajorAxis;

    private double     eccentricity;

    private double     orbitalInclination;

    private double     periapsis;

    private long       orbitalPeriod;

    private boolean    wasDiscovered;

    private boolean    wasMapped;

}
