package elite.dangerous.events.stationservices;

import java.util.Date;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class MissionAccepted.
 */
public class MissionAccepted extends Event implements Trigger {

	/**
     * The faction.
     */
	public String faction;
	
	/**
     * The name.
     */
	public String name;
	
	/**
     * The localised name.
     */
	public String localisedName;
	
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
     * The influence.
     */
	public String influence;
	
	/**
     * The reputation.
     */
	public String reputation;
	
	/**
     * The reward.
     */
	public Long reward;
	
	/**
     * The mission ID.
     */
	public Long missionID;
	
	/**
     * The expiry.
     */
	public Date expiry;

}
