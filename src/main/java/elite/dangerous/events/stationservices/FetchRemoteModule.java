package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class FetchRemoteModule.
 */
public class FetchRemoteModule extends Event implements Trigger {

	/**
     * The storage slots.
     */
	public Integer storageSlots;
	
	/**
     * The server id.
     */
	public Integer serverId;
	
	/**
     * The transfer cost.
     */
	public Integer transferCost;
	
	/**
     * The transfer time.
     */
	public Integer transferTime;
	
	/**
     * The ship id.
     */
	public Integer shipId;
	
	/**
     * The stored item.
     */
	public String storedItem;
	
	/**
     * The stored item localised.
     */
	public String storedItemLocalised;
	
	/**
     * The ship.
     */
	public String ship;

}
