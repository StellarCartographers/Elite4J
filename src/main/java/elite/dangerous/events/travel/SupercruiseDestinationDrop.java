package elite.dangerous.events.travel;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class SupercruiseDestinationDrop.
 */
public class SupercruiseDestinationDrop extends Event implements Trigger {

	/**
     * The type.
     */
	public String type;
	
	/**
     * The threat.
     */
	public Integer threat;
	
	/**
     * The market ID.
     */
	public Long marketID;
}
