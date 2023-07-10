package elite.dangerous.events.travel;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class Touchdown.
 */
public class Touchdown extends Event implements Trigger {

	/**
     * The player controlled.
     */
	public Boolean playerControlled;
	
	/**
     * The longitude.
     */
	public Double latitude, longitude;
	
	/**
     * The nearest destination.
     */
	public String nearestDestination;
	
	/**
     * The nearest destination localised.
     */
	public String nearestDestinationLocalised;

}
