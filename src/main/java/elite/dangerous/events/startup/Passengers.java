package elite.dangerous.events.startup;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.PassengerRecord;

/**
 * The Class Passengers.
 */
public class Passengers extends Event implements Trigger {

	/**
     * The manifest.
     */
	public List<PassengerRecord> manifest;

}
