package elite.dangerous.events.exploration;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class FSSDiscoveryScan.
 */
public class FSSDiscoveryScan extends Event implements Trigger {

	/**
     * The system name.
     */
	public String systemName;
	
	/**
     * The system address.
     */
	public Long systemAddress;
	
	/**
     * The progress.
     */
	public Double progress;
	
	/**
     * The non body count.
     */
	public Integer bodyCount, nonBodyCount;

}
