package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class RestockVehicle.
 */
public class RestockVehicle extends Event implements Trigger {

	/**
     * The loadout.
     */
	public String type, loadout;
	
	/**
     * The cost.
     */
	public Long cost;
	
	/**
     * The count.
     */
	public Integer count;

}
