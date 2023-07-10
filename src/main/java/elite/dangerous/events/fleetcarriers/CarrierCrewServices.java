package elite.dangerous.events.fleetcarriers;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CarrierCrewServices.
 */
public class CarrierCrewServices extends Event implements Trigger {

	/**
     * The operation.
     */
	public String crewName, crewRole, operation;
	
	/**
     * The carrier ID.
     */
	public Long carrierID;

}
