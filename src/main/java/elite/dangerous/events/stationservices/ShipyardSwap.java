package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ShipyardSwap.
 */
public class ShipyardSwap extends Event implements Trigger {

	/**
     * The store old ship.
     */
	public String shipType, shipTypeLocalised, storeOldShip;
	
	/**
     * The store ship ID.
     */
	public Integer shipID, storeShipID;
	
	/**
     * The market ID.
     */
	public Long marketID;

}
