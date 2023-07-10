package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ShipyardBuy.
 */
public class ShipyardBuy extends Event implements Trigger {

	/**
     * The sell old ship.
     */
	public String shipType, sellOldShip;
	
	/**
     * The sell price.
     */
	public Long shipPrice, sellPrice;
	
	/**
     * The sell ship ID.
     */
	public Integer sellShipID;

}
