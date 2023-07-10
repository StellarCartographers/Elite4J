package elite.dangerous.events.combat;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class FactionKillBond.
 */
public class FactionKillBond extends Event implements Trigger {

	/**
     * The reward.
     */
	public Integer reward;
	
	/**
     * The awarding faction.
     */
	public String awardingFaction;
	
	/**
     * The victim faction.
     */
	public String victimFaction;

}
