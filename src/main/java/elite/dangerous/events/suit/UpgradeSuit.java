package elite.dangerous.events.suit;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class UpgradeSuit.
 */
public class UpgradeSuit extends Event implements Trigger {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The name localised.
     */
	public String nameLocalised;
	
	/**
     * The suit ID.
     */
	public Long suitID;
	
	/**
     * The suit class.
     */
	@SerializedName("Class")
	public Integer suitClass;
	
	/**
     * The cost.
     */
	public Long cost;
}
