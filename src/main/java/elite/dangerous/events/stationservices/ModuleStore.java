package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ModuleStore.
 */
public class ModuleStore extends Event implements Trigger {

	/**
     * The slot.
     */
	public String slot;
	
	/**
     * The stored item.
     */
	public String storedItem;
	
	/**
     * The stored item localised.
     */
	public String storedItemLocalised;
	
	/**
     * The ship.
     */
	public String ship;
	
	/**
     * The ship ID.
     */
	public Integer shipID;
	
	/**
     * The hot.
     */
	public Boolean hot;
	
	/**
     * The market ID.
     */
	public Long marketID;

}
