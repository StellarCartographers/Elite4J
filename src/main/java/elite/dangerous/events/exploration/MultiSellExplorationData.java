package elite.dangerous.events.exploration;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.station.Discovered;

/**
 * The Class MultiSellExplorationData.
 */
public class MultiSellExplorationData extends Event implements Trigger {

	/**
     * The discovered.
     */
	public List<Discovered> discovered;
	
	/**
     * The bonus.
     */
	public Integer baseValue, totalEarnings, bonus;

}
