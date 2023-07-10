package elite.dangerous.events.other;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class LaunchDrone.
 */
public class LaunchDrone extends Event implements Trigger {

	/**
     * The Constant TYPES.
     */
	public static final String[] TYPES = { "Hatchbreaker", "FuelTransfer", "Collection", "Prospector", "Repair",
			"Research", "Decontamination" };

	/**
     * The type.
     */
	public String type;

}
