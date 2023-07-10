package elite.dangerous.events.travel;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class SupercruiseExit.
 */
public class SupercruiseExit extends Event implements Trigger {

	/**
     * The star system.
     */
	public String starSystem;
	
	/**
     * The body.
     */
	public String body;
	
	/**
     * The body type.
     */
	public String bodyType;
	
	/**
     * The body ID.
     */
	public Integer bodyID;

}
