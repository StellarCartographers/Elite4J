package elite.dangerous.events.other;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class AfmuRepairs.
 */
public class AfmuRepairs extends Event implements Trigger {

	/**
     * The module.
     */
	public String module;
	
	/**
     * The module localised.
     */
	public String moduleLocalised;
	
	/**
     * The fully repaired.
     */
	public Boolean fullyRepaired;
	
	/**
     * The health.
     */
	public Float health;

}
