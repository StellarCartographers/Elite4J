package elite.dangerous.events.other;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CrewLaunchFighter.
 */
public class CrewLaunchFighter extends Event implements Trigger {

	/**
     * The crew.
     */
	public String crew;
	
	/**
     * The id.
     */
	@SerializedName("ID")
	public Long id;

}
