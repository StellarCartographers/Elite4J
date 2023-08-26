package elite.dangerous.events.backpack;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * When picking up items from the ground
 */
public class CollectItems extends Event implements Trigger {

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
	
	/**
     * The stolen.
     */
	public Boolean stolen;

}
