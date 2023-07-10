package elite.dangerous.events.combat;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class HeatDamage.
 */
public class HeatDamage extends Event implements Trigger {

	/**
     * The id.
     */
	@SerializedName("ID")
	public String id;

}
