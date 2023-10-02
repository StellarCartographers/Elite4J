package elite.dangerous.journal.events.exploration;

import java.util.List;

import elite.dangerous.journal.models.scan.AtmosphereItem;
import elite.dangerous.journal.models.scan.Composition;
import elite.dangerous.journal.models.scan.Material;
import elite.dangerous.journal.models.scan.Parents;

public class ScanPlanetOrMoon extends Scan
{

    public double axialTilt;

    public String terraformState;

    public String planetClass;

    public String atmosphere;

    public String atmosphereType;

    public String volcanism;

    public String reserveLevel;

    public double massEM;

    public double surfaceGravity;

    public double surfacePressure;

    public int subclass;

    public boolean tidalLock;

    public boolean landable;

    public Parents parents;

    public List<AtmosphereItem> atmosphereComposition;

    public List<Material> materials;

    public Composition composition;

}
