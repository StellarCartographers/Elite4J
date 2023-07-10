package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class PayFines.
 */
public class PayFines extends Event implements Trigger {

	/**
     * The amount.
     */
	public Long amount;
	
	/**
     * The ship ID.
     */
	public Integer shipID;
	
	/**
     * The all fines.
     */
	public Boolean allFines;

}
