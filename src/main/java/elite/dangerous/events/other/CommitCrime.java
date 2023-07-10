package elite.dangerous.events.other;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CommitCrime.
 */
public class CommitCrime extends Event implements Trigger {

	/**
     * The crime type.
     */
	public String crimeType;
	
	/**
     * The faction.
     */
	public String faction;
	
	/**
     * The victim.
     */
	public String victim;
	
	/**
     * The bounty.
     */
	public Integer bounty;
	
	/**
     * The fine.
     */
	public Integer fine;

}
