package elite.dangerous.events.fleetcarriers;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CarrierDecommission.
 */
public class CarrierDecommission extends Event implements Trigger {

	/**
     * The carrier ID.
     */
	public Long carrierID;
	
	/**
     * The scrap refund.
     */
	public Long scrapRefund;
	
	/**
     * The scrap time.
     */
	public Long scrapTime;

}
