package elite.dangerous.events.fleetcarriers;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CarrierFinance.
 */
public class CarrierFinance extends Event implements Trigger {

	/**
     * The reserve percent.
     */
	public Double taxRate, reservePercent;
	
	/**
     * The available balance.
     */
	public Long carrierID, carrierBalance, reserveBalance, availableBalance;

}
