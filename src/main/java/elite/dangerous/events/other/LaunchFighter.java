package elite.dangerous.events.other;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class LaunchFighter.
 */
public class LaunchFighter extends Event implements Trigger {

	/**
     * The loadout.
     */
	public String loadout;
	
	/**
     * The id.
     */
	@SerializedName("ID")
	public Long id;
	
	/**
     * The player controlled.
     */
	public Boolean playerControlled;

}
