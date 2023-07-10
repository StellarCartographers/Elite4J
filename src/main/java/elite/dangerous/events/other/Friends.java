package elite.dangerous.events.other;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class Friends.
 */
public class Friends extends Event implements Trigger {

	/**
     * The Constant STATUS.
     */
	public static final String[] STATUS = { "Requested", "Declined", "Added", "Lost", "Offline", "Online" };

	/**
     * The status.
     */
	public String status;
	
	/**
     * The name.
     */
	public String name;

}
