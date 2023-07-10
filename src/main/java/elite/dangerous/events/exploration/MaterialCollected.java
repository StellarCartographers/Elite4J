package elite.dangerous.events.exploration;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class MaterialCollected.
 */
public class MaterialCollected extends Event implements Trigger {

	/**
     * The name.
     */
	public String category, name;
	
	/**
     * The name localised.
     */
	public String nameLocalised;
	
	/**
     * The count.
     */
	public Integer count;

}
