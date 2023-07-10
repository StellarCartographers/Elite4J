package elite.dangerous.events.combat;

import elite.dangerous.Trigger;

/**
 * The Class DiedByPVP.
 */
public class DiedByPVP extends Died implements Trigger {
	
	/**
     * The killer name.
     */
	public String killerName;
	
	/**
     * The killer ship.
     */
	public String killerShip;
	
	/**
     * The killer rank.
     */
	public String killerRank;
}