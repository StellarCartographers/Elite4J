package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ScientificResearch.
 */
public class ScientificResearch extends Event implements Trigger {

	/**
     * The market ID.
     */
	public Integer marketID;
	
	/**
     * The name.
     */
	public String name;
	
	/**
     * The category.
     */
	public String category;
	
	/**
     * The count.
     */
	public Integer count;

}
