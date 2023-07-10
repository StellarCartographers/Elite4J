package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class MissionRedirected.
 */
public class MissionRedirected extends Event implements Trigger {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The new destination station.
     */
	public String newDestinationStation;
	
	/**
     * The new destination system.
     */
	public String newDestinationSystem;
	
	/**
     * The old destination station.
     */
	public String oldDestinationStation;
	
	/**
     * The old destination system.
     */
	public String oldDestinationSystem;
	
	/**
     * The mission ID.
     */
	public Long missionID;

}
