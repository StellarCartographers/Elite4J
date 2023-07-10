package elite.dangerous.events.trade;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class EjectCargo.
 */
public class EjectCargo extends Event implements Trigger {

	/**
     * The type.
     */
	public String type;
	
	/**
     * The type localised.
     */
	public String typeLocalised;
	
	/**
     * The powerplay origin.
     */
	public String powerplayOrigin;
	
	/**
     * The count.
     */
	public Integer count;
	
	/**
     * The mission ID.
     */
	public Long missionID;
	
	/**
     * The abandoned.
     */
	public Boolean abandoned;

}
