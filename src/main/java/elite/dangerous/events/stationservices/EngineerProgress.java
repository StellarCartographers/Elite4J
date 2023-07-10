package elite.dangerous.events.stationservices;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.engineer.Engineer;

/**
 * The Class EngineerProgress.
 */
public class EngineerProgress extends Event implements Trigger {

	/**
     * The engineers.
     */
	public List<Engineer> engineers;
	
	/**
     * The rank.
     */
	public Integer rank;
	
	/**
     * The rank progress.
     */
	public Double rankProgress;

}
