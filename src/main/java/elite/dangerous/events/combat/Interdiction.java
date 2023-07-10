package elite.dangerous.events.combat;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class Interdiction.
 */
public class Interdiction extends Event implements Trigger {

	/**
     * The is player.
     */
	public Boolean success, isPlayer;
	
	/**
     * The power.
     */
	public String interdicted, faction, power;
	
	/**
     * The combat rank.
     */
	public Integer combatRank;

}
