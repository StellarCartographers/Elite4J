package elite.dangerous.events.other;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class LaunchSRV.
 */
public class LaunchSRV extends Event implements Trigger {

	/**
     * The loadout.
     */
	public String loadout;
	
	/**
     * The id.
     */
	@SerializedName("ID")
	public Long id;

}
