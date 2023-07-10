package elite.dangerous.events.exploration;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class SellExplorationData.
 */
public class SellExplorationData extends Event implements Trigger {

	/**
     * The discovered.
     */
	public String[] systems, discovered;
	
	/**
     * The total earnings.
     */
	public Integer baseValue, bonus, totalEarnings;

}
