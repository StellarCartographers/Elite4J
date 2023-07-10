package elite.dangerous.events.travel;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class Liftoff.
 */
public class Liftoff extends Event implements Trigger {

	/**
     * The player controlled.
     */
	public Boolean playerControlled;
	
	/**
     * The latitude.
     */
	public Double longitude, latitude;
	
	/**
     * The nearest destination.
     */
	public String nearestDestination;
	
	/**
     * The nearest destination localised.
     */
	public String nearestDestinationLocalised;

}
