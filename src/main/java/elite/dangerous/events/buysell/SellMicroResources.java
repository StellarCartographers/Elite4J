package elite.dangerous.events.buysell;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.MicroResource;

/**
 * The Class SellMicroResources.
 */
public class SellMicroResources extends Event implements Trigger {

	/**
     * The micro resources.
     */
	public List<MicroResource> microResources;
	
	/**
     * The price.
     */
	public Long price;
	
	/**
     * The market ID.
     */
	public Long marketID;
}
