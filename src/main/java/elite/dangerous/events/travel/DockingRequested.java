package elite.dangerous.events.travel;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class DockingRequested.
 */
public class DockingRequested extends Event implements Trigger {

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
