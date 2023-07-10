package elite.dangerous.events.exploration;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.scan.Ring;

/**
 * The Class Scan.
 */
public class Scan extends Event implements Trigger {

	/**
     * The scan type.
     */
	public String scanType;
	
	/**
     * The body name.
     */
	public String bodyName;
	
	/**
     * The body ID.
     */
	public Integer bodyID;
	
	/**
     * The star system.
     */
	public String starSystem;
	
	/**
     * The distance from arrival LS.
     */
	public Double distanceFromArrivalLS;
	
	/**
     * The rotation period.
     */
	public Double rotationPeriod;
	
	/**
     * The surface temperature.
     */
	public Double surfaceTemperature;
	
	/**
     * The rings.
     */
	public List<Ring> rings;
	
	/**
     * The semi major axis.
     */
	public Long semiMajorAxis;
	
	/**
     * The eccentricity.
     */
	public Double eccentricity;
	
	/**
     * The orbital inclination.
     */
	public Double orbitalInclination;
	
	/**
     * The periapsis.
     */
	public Double periapsis;
	
	/**
     * The orbital period.
     */
	public Long orbitalPeriod;

}
