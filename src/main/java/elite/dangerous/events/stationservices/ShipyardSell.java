package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ShipyardSell.
 */
public class ShipyardSell extends Event implements Trigger {

	/**
     * The ship type localised.
     */
	public String shipType, shipTypeLocalised;
	
	/**
     * The sell ship ID.
     */
	public Integer sellShipID;
	
	/**
     * The market ID.
     */
	public Long shipPrice, marketID;

}
