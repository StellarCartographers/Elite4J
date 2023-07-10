package elite.dangerous.events.exploration;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class FSSAllBodiesFound.
 */
public class FSSAllBodiesFound extends Event implements Trigger {

	/**
     * The system name.
     */
	public String systemName;
	
	/**
     * The system address.
     */
	public Long systemAddress;
	
	/**
     * The count.
     */
	public Integer count;

}
