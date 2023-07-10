package elite.dangerous.events.startup;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class Powerplay.
 */
public class Powerplay extends Event implements Trigger {

	/**
     * The power.
     */
	public String power;
	
	/**
     * The rank.
     */
	public Integer rank;
	
	/**
     * The merits.
     */
	public Integer merits;
	
	/**
     * The votes.
     */
	public Integer votes;
	
	/**
     * The time pledged.
     */
	public Integer timePledged;

}
