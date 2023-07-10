package elite.dangerous.events.trade;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CollectCargo.
 */
public class CollectCargo extends Event implements Trigger {

	/**
     * The type.
     */
	public String type;
	
	/**
     * The mission ID.
     */
	public Long missionID;
	
	/**
     * The stolen.
     */
	public Boolean stolen;

}
