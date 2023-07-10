package elite.dangerous.events.exploration;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class Screenshot.
 */
public class Screenshot extends Event implements Trigger {

	/**
     * The body.
     */
	public String filename, system, body;
	
	/**
     * The heading.
     */
	public Integer width, height, heading;
	
	/**
     * The altitude.
     */
	public Double latitude, longitude, altitude;

}
