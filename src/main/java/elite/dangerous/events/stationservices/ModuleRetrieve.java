package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ModuleRetrieve.
 */
public class ModuleRetrieve extends Event implements Trigger {

	/**
     * The market ID.
     */
	public Long marketID;
	
	/**
     * The slot.
     */
	public String slot;
	
	/**
     * The retrieved item.
     */
	public String retrievedItem;
	
	/**
     * The retrieved item localised.
     */
	public String retrievedItemLocalised;
	
	/**
     * The ship.
     */
	public String ship;
	
	/**
     * The swap out item.
     */
	public String swapOutItem;
	
	/**
     * The swap out item localised.
     */
	public String swapOutItemLocalised;
	
	/**
     * The ship ID.
     */
	public Integer shipID;
	
	/**
     * The hot.
     */
	public Boolean hot;

}
