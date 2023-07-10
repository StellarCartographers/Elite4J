package elite.dangerous.events.exploration;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class MaterialDiscarded.
 */
public class MaterialDiscarded extends Event implements Trigger {

	/**
     * The name.
     */
	public String category, name;
	
	/**
     * The count.
     */
	public Integer count;

}
