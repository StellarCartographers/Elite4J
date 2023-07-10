package elite.dangerous.events.exploration;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class SAAScanComplete.
 */
public class SAAScanComplete extends Event implements Trigger {

	/**
     * The body name.
     */
	public String bodyName;
	
	/**
     * The efficiency target.
     */
	public Integer bodyID, probesUsed, efficiencyTarget;
	
	/**
     * The system address.
     */
	public Long systemAddress;
	
	/**
     * The descoverers.
     */
	public List<String> descoverers;
	
	/**
     * The mappers.
     */
	public List<String> mappers;

}
