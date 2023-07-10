package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class SellShipOnRebuy.
 */
public class SellShipOnRebuy extends Event implements Trigger {

	/**
     * The ship type.
     */
	public String shipType;
	
	/**
     * The system.
     */
	public String system;
	
	/**
     * The sell ship id.
     */
	public Integer sellShipId;
	
	/**
     * The ship price.
     */
	public Long shipPrice;

}
