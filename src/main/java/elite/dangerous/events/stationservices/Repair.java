package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class Repair.
 */
public class Repair extends Event implements Trigger {

	/**
     * The item.
     */
	public String item;
	
	/**
     * The cost.
     */
	public Long cost;

}
