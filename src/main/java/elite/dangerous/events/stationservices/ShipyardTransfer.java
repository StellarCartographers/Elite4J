package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ShipyardTransfer.
 */
public class ShipyardTransfer extends Event implements Trigger {

	/**
     * The system.
     */
	public String shipType, shipTypeLocalised, system;
	
	/**
     * The ship ID.
     */
	public Integer shipID;
	
	/**
     * The market ID.
     */
	public Long shipMarketID, transferPrice, transferTime, marketID;
	
	/**
     * The distance.
     */
	public Double distance;

}
