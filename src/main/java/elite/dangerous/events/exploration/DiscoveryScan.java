package elite.dangerous.events.exploration;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class DiscoveryScan.
 */
public class DiscoveryScan extends Event implements Trigger {

	/**
     * The system address.
     */
	public Long systemAddress;
	
	/**
     * The bodies.
     */
	public Integer bodies;

}
