package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class PayBounties.
 */
public class PayBounties extends Event implements Trigger {

	/**
     * The amount.
     */
	public Long amount;
	
	/**
     * The faction localised.
     */
	public String faction, factionLocalised;
	
	/**
     * The broker percentage.
     */
	public Integer shipID, brokerPercentage;

}
