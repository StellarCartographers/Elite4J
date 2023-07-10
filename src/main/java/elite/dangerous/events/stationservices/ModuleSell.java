package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ModuleSell.
 */
public class ModuleSell extends Event implements Trigger {

	/**
     * The slot.
     */
	public String slot;
	
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
     * The market ID.
     */
	public Long sellPrice, marketID;
	
	/**
     * The ship ID.
     */
	public Integer shipID;

}
