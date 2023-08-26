package elite.dangerous.events.backpack;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.MicroResource;

/**
 * This event is logged when the player exchanges owned microresources to receive some other type of microresource
 */
public class TradeMicroResources extends Event implements Trigger {

	public List<MicroResource> offered;

	/**
	 * name of resource received
	 */
	public String received;

	/**
	 *  number received
	 */
	public int count;

	public long marketID;

	public MicroResource.Category category;
}
