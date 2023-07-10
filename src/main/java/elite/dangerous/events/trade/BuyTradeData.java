package elite.dangerous.events.trade;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class BuyTradeData.
 */
public class BuyTradeData extends Event implements Trigger {
	
	/**
     * The system.
     */
	public String system;
	
	/**
     * The cost.
     */
	public Integer cost;
}
