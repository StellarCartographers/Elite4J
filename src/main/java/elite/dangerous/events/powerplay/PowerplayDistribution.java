package elite.dangerous.events.powerplay;

import elite.dangerous.base.Event;

/**
 * The Class PowerplayDistribution.
 */
public abstract class PowerplayDistribution extends Event {

	/**
     * The power.
     */
	public String power;
	
	/**
     * The type.
     */
	public String type;
	
	/**
     * The count.
     */
	public Integer count;
}
