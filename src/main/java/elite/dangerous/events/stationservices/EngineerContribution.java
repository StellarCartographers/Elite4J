package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class EngineerContribution.
 */
public class EngineerContribution extends Event implements Trigger {

	/**
     * The engineer.
     */
	public String engineer;
	
	/**
     * The type.
     */
	public String type;
	
	/**
     * The commodity.
     */
	public String commodity;
	
	/**
     * The faction.
     */
	public String faction;
	
	/**
     * The material.
     */
	public String material;
	
	/**
     * The engineer ID.
     */
	public Integer engineerID;
	
	/**
     * The quantity.
     */
	public Integer quantity;
	
	/**
     * The total quantity.
     */
	public Integer totalQuantity;

}
