package elite.dangerous.events.exploration;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class MaterialDiscovered.
 */
public class MaterialDiscovered extends Event implements Trigger {

	/**
     * The name.
     */
	public String category, name;
	
	/**
     * The discovery number.
     */
	public Integer discoveryNumber;

}
