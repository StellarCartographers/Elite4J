package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ModuleSellRemote.
 */
public class ModuleSellRemote extends Event implements Trigger {

	/**
     * The ship ID.
     */
	public Integer storageSlot, shipID;
	
	/**
     * The sell item.
     */
	public String sellItem;
	
	/**
     * The sell item localised.
     */
	public String sellItemLocalised;
	
	/**
     * The ship.
     */
	public String ship;
	
	/**
     * The sell price.
     */
	public Long serverID, sellPrice;

}
