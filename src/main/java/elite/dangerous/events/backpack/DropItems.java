package elite.dangerous.events.backpack;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class DropItems.
 */
public class DropItems extends Event implements Trigger {

	public String name;

	public String type;

	public Long ownerID;

	public Integer count;

}
