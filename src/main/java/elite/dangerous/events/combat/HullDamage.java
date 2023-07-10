package elite.dangerous.events.combat;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class HullDamage.
 */
public class HullDamage extends Event implements Trigger {

	/**
     * The health.
     */
	public Double health;
	
	/**
     * The player pilot.
     */
	public Boolean playerPilot;
	
	/**
     * The fighter.
     */
	public Boolean fighter;

}
