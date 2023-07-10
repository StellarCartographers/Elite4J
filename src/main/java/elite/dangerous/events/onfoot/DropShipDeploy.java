package elite.dangerous.events.onfoot;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class DropShipDeploy.
 */
public class DropShipDeploy extends Event implements Trigger {

	/**
     * The star system.
     */
	public String starSystem;
	
	/**
     * The system address.
     */
	public Long systemAddress;
	
	/**
     * The body.
     */
	public String body;
	
	/**
     * The body ID.
     */
	public Long bodyID;
	
	/**
     * The on station.
     */
	public Boolean onStation;
	
	/**
     * The on planet.
     */
	public Boolean onPlanet;

}
