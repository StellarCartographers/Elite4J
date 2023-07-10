package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CrewAssign.
 */
public class CrewAssign extends Event implements Trigger {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The role.
     */
	public String role;
	
	/**
     * The crew ID.
     */
	public Integer crewID;

}
