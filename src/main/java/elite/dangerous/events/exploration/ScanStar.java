package elite.dangerous.events.exploration;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;

/**
 * The Class ScanStar.
 */
public class ScanStar extends Scan implements Trigger {

	/**
     * The star type.
     */
	public String starType;
	
	/**
     * The luminosity.
     */
	public String luminosity;
	
	/**
     * The system address.
     */
	public Long systemAddress;
	
	/**
     * The stellar mass.
     */
	public Double stellarMass;
	
	/**
     * The radius.
     */
	public Long radius;
	
	/**
     * The absolute magnitude.
     */
	public Double absoluteMagnitude;
	
	/**
     * The age MY.
     */
	@SerializedName("Age_MY")
	public Long ageMY;
	
	/**
     * The was mapped.
     */
	public Boolean wasMapped;
	
	/**
     * The was discovered.
     */
	public Boolean wasDiscovered;

}
