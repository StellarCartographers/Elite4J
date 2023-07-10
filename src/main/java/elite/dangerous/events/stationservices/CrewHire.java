package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CrewHire.
 */
public class CrewHire extends Event implements Trigger {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The faction.
     */
	public String faction;
	
	/**
     * The crew ID.
     */
	public Integer crewID;
	
	/**
     * The cost.
     */
	public Integer cost;
	
	/**
     * The combat rank.
     */
	public Integer combatRank;

}
