package elite.dangerous.events.buysell;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.MicroResource;

/**
 * The Class BuyMicroResources.
 */
public class BuyMicroResources extends Event implements Trigger {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The name localised.
     */
	public String nameLocalised;
	
	/**
     * The category.
     */
	public MicroResource.Category category;
	
	/**
     * The count.
     */
	public Integer count;
	
	/**
     * The price.
     */
	public Long price;
	
	/**
     * The market ID.
     */
	public Long marketID;
}
