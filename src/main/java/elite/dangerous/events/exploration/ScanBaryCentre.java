package elite.dangerous.events.exploration;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ScanBaryCentre.
 */
public class ScanBaryCentre extends Event implements Trigger {

	/**
     * The body ID.
     */
	public Integer bodyID;
	
	/**
     * The star system.
     */
	public String starSystem;
	
	/**
     * The system address.
     */
	public Long systemAddress;
	
	/**
     * The semi major axis.
     */
	public Double semiMajorAxis;
	
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
	public Double orbitalPeriod;
	
	/**
     * The ascending node.
     */
	public Double ascendingNode;
	
	/**
     * The mean anomaly.
     */
	public Double meanAnomaly;

}
