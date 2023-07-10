package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CargoDepot.
 */
public class CargoDepot extends Event implements Trigger {

	/**
     * The mission ID.
     */
	public Long missionID;
	
	/**
     * The start market ID.
     */
	public Long startMarketID;
	
	/**
     * The end market ID.
     */
	public Long endMarketID;
	
	/**
     * The count.
     */
	public Integer count;
	
	/**
     * The item collected.
     */
	public Integer itemCollected;
	
	/**
     * The items delivered.
     */
	public Integer itemsDelivered;
	
	/**
     * The total items to deliver.
     */
	public Integer totalItemsToDeliver;
	
	/**
     * The update type.
     */
	public String updateType;
	
	/**
     * The cargo type.
     */
	public String cargoType;
	
	/**
     * The progress.
     */
	public Double progress;

}
