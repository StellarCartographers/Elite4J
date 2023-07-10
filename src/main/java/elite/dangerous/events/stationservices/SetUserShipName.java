package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class SetUserShipName.
 */
public class SetUserShipName extends Event implements Trigger {

	/**
     * The ship.
     */
	public String ship;
	
	/**
     * The ship ID.
     */
	public Integer shipID;
	
	/**
     * The user ship id.
     */
	public String userShipName, userShipId;

}
