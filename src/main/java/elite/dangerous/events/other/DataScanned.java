package elite.dangerous.events.other;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class DataScanned.
 */
public class DataScanned extends Event implements Trigger {

	/**
     * The Constant TYPES.
     */
	public static final String[] TYPES = { "DataLink", "DataPoint", "ListeningPost", "AbandonedDatalog",
			"WreckedShip" };

	/**
     * The type.
     */
	public String type;

}
