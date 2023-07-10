package elite.dangerous.events.trade;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class MarketBuy.
 */
public class MarketBuy extends Event implements Trigger {

	/**
     * The market ID.
     */
	public Long marketID;
	
	/**
     * The type.
     */
	public String type;
	
	/**
     * The type localised.
     */
	public String typeLocalised;
	
	/**
     * The count.
     */
	public Integer count;
	
	/**
     * The buy price.
     */
	public Integer buyPrice;
	
	/**
     * The total cost.
     */
	public Integer totalCost;

}
