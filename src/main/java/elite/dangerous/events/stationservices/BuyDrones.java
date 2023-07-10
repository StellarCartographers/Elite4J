package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class BuyDrones.
 */
public class BuyDrones extends Event implements Trigger {

	/**
     * The type.
     */
	public String type;
	
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
