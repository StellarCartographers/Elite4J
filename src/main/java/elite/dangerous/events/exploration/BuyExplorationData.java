package elite.dangerous.events.exploration;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class BuyExplorationData.
 */
public class BuyExplorationData extends Event implements Trigger {

	/**
     * The system.
     */
	public String system;
	
	/**
     * The cost.
     */
	public Integer cost;

}
