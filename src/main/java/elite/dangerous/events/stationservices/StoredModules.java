package elite.dangerous.events.stationservices;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.StoredModule;

/**
 * The Class StoredModules.
 */
public class StoredModules extends Event implements Trigger {

	/**
     * The market ID.
     */
	public Long marketID;
	
	/**
     * The star system.
     */
	public String stationName, starSystem;
	
	/**
     * The items.
     */
	public List<StoredModule> items;

}
