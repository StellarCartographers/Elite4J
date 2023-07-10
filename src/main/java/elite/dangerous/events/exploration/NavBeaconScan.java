package elite.dangerous.events.exploration;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class NavBeaconScan.
 */
public class NavBeaconScan extends Event implements Trigger {

	/**
     * The system address.
     */
	public Long systemAddress;
	
	/**
     * The num bodies.
     */
	public Integer numBodies;

}
