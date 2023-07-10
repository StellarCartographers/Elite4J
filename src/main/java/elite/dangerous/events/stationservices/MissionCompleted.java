package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class MissionCompleted.
 */
public class MissionCompleted extends Event implements Trigger {

	/**
     * The faction.
     */
	public String faction;
	
	/**
     * The name.
     */
	public String name;
	
	/**
     * The target faction.
     */
	public String targetFaction;
	
	/**
     * The destination system.
     */
	public String destinationSystem;
	
	/**
     * The destination station.
     */
	public String destinationStation;
	
	/**
     * The mission ID.
     */
	public Long missionID;
	
	/**
     * The reward.
     */
	public Long reward;

}
