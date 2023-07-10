package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class SearchAndRescue.
 */
public class SearchAndRescue extends Event implements Trigger {

	/**
     * The reward.
     */
	public Long marketID, reward;
	
	/**
     * The name localised.
     */
	public String name, nameLocalised;
	
	/**
     * The count.
     */
	public Integer count;

}
