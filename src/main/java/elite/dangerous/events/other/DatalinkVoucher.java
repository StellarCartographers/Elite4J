package elite.dangerous.events.other;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class DatalinkVoucher.
 */
public class DatalinkVoucher extends Event implements Trigger {

	/**
     * The reward.
     */
	public Long reward;
	
	/**
     * The victim faction.
     */
	public String victimFaction;
	
	/**
     * The payee faction.
     */
	public String payeeFaction;

}
