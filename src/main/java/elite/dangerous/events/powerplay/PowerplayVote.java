package elite.dangerous.events.powerplay;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class PowerplayVote.
 */
public class PowerplayVote extends Event implements Trigger {

	/**
     * The power.
     */
	public String power;
	
	/**
     * The votes.
     */
	public Integer votes;
	
	/**
     * The system.
     */
	public String system;

}
