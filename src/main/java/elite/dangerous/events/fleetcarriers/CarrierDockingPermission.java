package elite.dangerous.events.fleetcarriers;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CarrierDockingPermission.
 */
public class CarrierDockingPermission extends Event implements Trigger {

	/**
     * The carrier ID.
     */
	public Long carrierID;
	
	/**
     * The docking access.
     */
	public String dockingAccess;
	
	/**
     * The allow notorious.
     */
	public Boolean allowNotorious;

}
