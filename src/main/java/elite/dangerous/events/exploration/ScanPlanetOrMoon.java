package elite.dangerous.events.exploration;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.models.scan.AtmosphereItem;
import elite.dangerous.models.scan.Composition;
import elite.dangerous.models.scan.Material;
import elite.dangerous.models.scan.Parent;

/**
 * The Class ScanPlanetOrMoon.
 */
public class ScanPlanetOrMoon extends Scan implements Trigger {

	/**
     * The axial tilt.
     */
	public Double axialTilt;
	
	/**
     * The terraform state.
     */
	public String terraformState;
	
	/**
     * The planet class.
     */
	public String planetClass;
	
	/**
     * The atmosphere.
     */
	public String atmosphere;
	
	/**
     * The atmosphere type.
     */
	public String atmosphereType;
	
	/**
     * The volcanism.
     */
	public String volcanism;
	
	/**
     * The reserve level.
     */
	public String reserveLevel;
	
	/**
     * The mass EM.
     */
	public Double massEM;
	
	/**
     * The surface gravity.
     */
	public Double surfaceGravity;
	
	/**
     * The surface pressure.
     */
	public Double surfacePressure;
	
	/**
     * The subclass.
     */
	public Integer subclass;
	
	/**
     * The tidal lock.
     */
	public Boolean tidalLock;
	
	/**
     * The landable.
     */
	public Boolean landable;
	
	/**
     * The parents.
     */
	public List<Parent> parents;
	
	/**
     * The atmosphere composition.
     */
	public List<AtmosphereItem> atmosphereComposition;
	
	/**
     * The materials.
     */
	public List<Material> materials;
	
	/**
     * The composition.
     */
	public Composition composition;

}
