package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class MissionAbandoned.
 */
public class MissionAbandoned extends Event implements Trigger {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The mission ID.
     */
	public Long missionID;

}
