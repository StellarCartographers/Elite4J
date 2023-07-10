package elite.dangerous.events.other;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class Resurrect.
 */
public class Resurrect extends Event implements Trigger {

	/**
     * The option.
     */
	public String option;
	
	/**
     * The cost.
     */
	public Long cost;
	
	/**
     * The bankrupt.
     */
	public Boolean bankrupt;

}
