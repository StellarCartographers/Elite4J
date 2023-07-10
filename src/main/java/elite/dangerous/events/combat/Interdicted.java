package elite.dangerous.events.combat;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class Interdicted.
 */
public class Interdicted extends Event implements Trigger {

	/**
     * The is player.
     */
	public Boolean submitted, isPlayer;
	
	/**
     * The power.
     */
	public String interdictor, faction, power;
	
	/**
     * The combat rank.
     */
	public Integer combatRank;

}
