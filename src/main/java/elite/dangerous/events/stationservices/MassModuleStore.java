package elite.dangerous.events.stationservices;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.ModuleItem;

/**
 * The Class MassModuleStore.
 */
public class MassModuleStore extends Event implements Trigger {

	/**
     * The market ID.
     */
	public Long marketID;
	
	/**
     * The ship.
     */
	public String ship;
	
	/**
     * The ship ID.
     */
	public Integer shipID;
	
	/**
     * The items.
     */
	public List<ModuleItem> items;

}
