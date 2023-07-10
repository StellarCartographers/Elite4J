package elite.dangerous.events.travel;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class LeaveBody.
 */
public class LeaveBody extends Event implements Trigger {

	/**
     * The body.
     */
	public String starSystem, body;
	
	/**
     * The system address.
     */
	public Long systemAddress;
	
	/**
     * The body ID.
     */
	public Integer bodyID;

}
