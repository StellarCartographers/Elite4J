package elite.dangerous.events.other;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class VehicleSwitch.
 */
public class VehicleSwitch extends Event implements Trigger {

	/**
     * The Constant TOS.
     */
	public static final String[] TOS = { "Mothership", "Fighter" };

	/**
     * The to.
     */
	public String to;

}
