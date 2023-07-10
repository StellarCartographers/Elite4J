package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class MissionFailed.
 */
public class MissionFailed extends Event implements Trigger {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The mission ID.
     */
	public Long missionID;

}
