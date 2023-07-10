package elite.dangerous.events.buysell;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class SellWeapon.
 */
public class SellWeapon extends Event implements Trigger {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The price.
     */
	public Long price;
	
	/**
     * The suit module ID.
     */
	public Long suitModuleID;
}
