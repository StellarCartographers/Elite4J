package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ReservoirReplenished.
 */
public class ReservoirReplenished extends Event implements Trigger {

	/**
     * The fuel main.
     */
	public Double fuelMain;
	
	/**
     * The fuel reservoir.
     */
	public Double fuelReservoir;

}
