package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ShipyardNew.
 */
public class ShipyardNew extends Event implements Trigger {

	/**
     * The ship type.
     */
	public String shipType;
	
	/**
     * The new ship ID.
     */
	public Integer newShipID;

}
