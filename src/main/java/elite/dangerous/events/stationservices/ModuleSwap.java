package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ModuleSwap.
 */
public class ModuleSwap extends Event implements Trigger {

	/**
     * The market ID.
     */
	public Long marketID;
	
	/**
     * The ship.
     */
	public String fromSlot, toSlot, fromItem, fromItemLocalised, toItem, toItemLocalised, ship;
	
	/**
     * The ship ID.
     */
	public Integer shipID;

}
