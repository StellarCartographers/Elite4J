package elite.dangerous.events.travel;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class FSDTarget.
 */
public class FSDTarget extends Event implements Trigger {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The star class.
     */
	public String starClass;
	
	/**
     * The system address.
     */
	public Long systemAddress;
	
	/**
     * The remaining jumps in route.
     */
	public Integer remainingJumpsInRoute;

}
