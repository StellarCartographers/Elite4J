package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class SellDrones.
 */
public class SellDrones extends Event implements Trigger {

	/**
     * The type.
     */
	public String type;
	
	/**
     * The count.
     */
	public Integer count;
	
	/**
     * The total sale.
     */
	public Long sellPrice, totalSale;

}
