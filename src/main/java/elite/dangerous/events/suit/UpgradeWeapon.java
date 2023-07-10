package elite.dangerous.events.suit;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class UpgradeWeapon.
 */
public class UpgradeWeapon extends Event implements Trigger {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The name localised.
     */
	public String nameLocalised;
	
	/**
     * The suit module ID.
     */
	public Long suitModuleID;
	
	/**
     * The weapon class.
     */
	@SerializedName("Class")
	public Integer weaponClass;
	
	/**
     * The cost.
     */
	public Long cost;
}
