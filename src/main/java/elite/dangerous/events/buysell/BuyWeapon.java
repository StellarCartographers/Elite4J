package elite.dangerous.events.buysell;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class BuyWeapon.
 */
public class BuyWeapon extends Event implements Trigger {

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
     * The suit module ID.
     */
	public Long suitModuleID;
}
