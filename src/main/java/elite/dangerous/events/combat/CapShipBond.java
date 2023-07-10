package elite.dangerous.events.combat;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CapShipBond.
 */
public class CapShipBond extends Event implements Trigger {

	/**
     * The victim faction.
     */
	public String victimFaction;
	
	/**
     * The awarding faction.
     */
	public String awardingFaction;
	
	/**
     * The reward.
     */
	public Integer reward;

}
