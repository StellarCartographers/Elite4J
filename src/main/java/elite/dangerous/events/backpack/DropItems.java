package elite.dangerous.events.backpack;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class DropItems.
 */
public class DropItems extends Event implements Trigger {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The type.
     */
	public String type;
	
	/**
     * The owner ID.
     */
	public Long ownerID;
	
	/**
     * The count.
     */
	public Integer count;

}
