package elite.dangerous.events.travel;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class DockingDenied.
 */
public class DockingDenied extends Event implements Trigger {

	/**
     * The reason.
     */
	public String reason;
	
	/**
     * The station name.
     */
	public String stationName;
	
	/**
     * The station type.
     */
	public String stationType;
	
	/**
     * The market ID.
     */
	public Long marketID;

}
