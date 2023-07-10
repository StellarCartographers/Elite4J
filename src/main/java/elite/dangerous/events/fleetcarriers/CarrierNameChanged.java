package elite.dangerous.events.fleetcarriers;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CarrierNameChanged.
 */
public class CarrierNameChanged extends Event implements Trigger {

	/**
     * The carrier ID.
     */
	public Long carrierID;
	
	/**
     * The callsign.
     */
	public String callsign;
	
	/**
     * The name.
     */
	public String name;

}
