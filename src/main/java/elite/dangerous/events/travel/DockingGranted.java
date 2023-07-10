package elite.dangerous.events.travel;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class DockingGranted.
 */
public class DockingGranted extends Event implements Trigger {

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
	
	/**
     * The landing pad.
     */
	public Integer landingPad;

}
