package elite.dangerous.events.fleetcarriers;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CarrierBankTransfer.
 */
public class CarrierBankTransfer extends Event implements Trigger {

	/**
     * The carrier balance.
     */
	public Long deposit, whithdraw, carrierID, playerBalance, carrierBalance;

}
