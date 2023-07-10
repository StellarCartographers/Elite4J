package elite.dangerous.events.buysell;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class BuySuit.
 */
public class BuySuit extends Event implements Trigger {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The name localised.
     */
	public String nameLocalised;
	
	/**
     * The price.
     */
	public Long price;
	
	/**
     * The suit ID.
     */
	public Long suitID;
}
