package elite.dangerous.events.fleetcarriers;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CarrierJumpRequest.
 */
public class CarrierJumpRequest extends Event implements Trigger {

	/**
     * The carrier ID.
     */
	public Long carrierID;
	
	/**
     * The system name.
     */
	public String systemName;
	
	/**
     * The body.
     */
	public String body;
	
	/**
     * The system address.
     */
	public Long systemAddress;
	
	/**
     * The body ID.
     */
	public Integer bodyID;
	
	/**
     * The departure time.
     */
	public String departureTime;

}
