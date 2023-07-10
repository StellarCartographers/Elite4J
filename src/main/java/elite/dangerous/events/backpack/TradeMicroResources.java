package elite.dangerous.events.backpack;

import java.util.ArrayList;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.MicroResource;

/**
 * The Class TradeMicroResources.
 */
public class TradeMicroResources extends Event implements Trigger {

	/**
     * The offered.
     */
	public ArrayList<MicroResource> offered;
	
	/**
     * The received.
     */
	public String received;
	
	/**
     * The count.
     */
	public Integer count;
	
	/**
     * The market ID.
     */
	public Long marketID;
	
	/**
     * The category.
     */
	public MicroResource.Category category;
}
