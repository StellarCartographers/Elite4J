package elite.dangerous.events.startup;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.Mission;

/**
 * The Class Missions.
 */
public class Missions extends Event implements Trigger {

	/**
     * The active.
     */
	public List<Mission> active;
	
	/**
     * The failed.
     */
	public List<Mission> failed;
	
	/**
     * The complete.
     */
	public List<Mission> complete;

}
