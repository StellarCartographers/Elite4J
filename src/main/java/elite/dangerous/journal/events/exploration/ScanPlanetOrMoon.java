package elite.dangerous.journal.events.exploration;

import java.util.List;

import elite.dangerous.model.scan.AtmosphereItem;
import elite.dangerous.model.scan.Composition;
import elite.dangerous.model.scan.Material;
import elite.dangerous.model.scan.Parents;
import lombok.EliteObject;

@EliteObject
public class ScanPlanetOrMoon extends Scan
{

    private double               axialTilt;

    private String               terraformState;

    private String               planetClass;

    private String               atmosphere;

    private String               atmosphereType;

    private String               volcanism;

    private String               reserveLevel;

    private double               massEM;

    private double               surfaceGravity;

    private double               surfacePressure;

    private int                  subclass;

    private boolean              tidalLock;

    private boolean              landable;

    private Parents              parents;

    private List<AtmosphereItem> atmosphereComposition;

    private List<Material>       materials;

    private Composition          composition;

}
