package elite.dangerous.events.travel;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ApproachBody.
 */
public class ApproachBody extends Event implements Trigger {

	/**
     * The star system.
     */
	public String starSystem;
	
	/**
     * The body.
     */
	public String body;
	
	/**
     * The body ID.
     */
	public Integer bodyID;
	
	/**
     * The system address.
     */
	public Long systemAddress;

}
