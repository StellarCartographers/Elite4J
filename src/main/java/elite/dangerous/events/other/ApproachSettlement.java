package elite.dangerous.events.other;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ApproachSettlement.
 */
public class ApproachSettlement extends Event implements Trigger {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The body name.
     */
	public String bodyName;
	
	/**
     * The body ID.
     */
	public Integer bodyID;
	
	/**
     * The latitude.
     */
	public Double latitude;
	
	/**
     * The longitude.
     */
	public Double longitude;
	
	/**
     * The market ID.
     */
	public Long marketID;
	
	/**
     * The system address.
     */
	public Long systemAddress;

}
