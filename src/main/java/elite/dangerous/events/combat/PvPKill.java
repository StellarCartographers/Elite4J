package elite.dangerous.events.combat;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class PvPKill.
 */
public class PvPKill extends Event implements Trigger {

	/**
     * The victim.
     */
	public String victim;
	
	/**
     * The combat rank.
     */
	public Integer combatRank;

}
