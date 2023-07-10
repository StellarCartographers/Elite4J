package elite.dangerous.events.travel;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class Undocked.
 */
public class Undocked extends Event implements Trigger {

	/**
     * The station type.
     */
	public String stationName, stationType;
	
	/**
     * The market ID.
     */
	public Long marketID;

}
