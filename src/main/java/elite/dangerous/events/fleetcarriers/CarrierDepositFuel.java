package elite.dangerous.events.fleetcarriers;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CarrierDepositFuel.
 */
public class CarrierDepositFuel extends Event implements Trigger {

	/**
     * The amount.
     */
	public Integer total, amount;
	
	/**
     * The carrier ID.
     */
	public Long carrierID;

}
