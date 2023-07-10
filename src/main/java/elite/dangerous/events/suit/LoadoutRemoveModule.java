package elite.dangerous.events.suit;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Suit;

/**
 * The Class LoadoutRemoveModule.
 */
public class LoadoutRemoveModule extends Suit implements Trigger {
	
	/**
     * The slot name.
     */
	public String slotName;
	
	/**
     * The module name.
     */
	public String moduleName;
	
	/**
     * The module name localised.
     */
	public String moduleNameLocalised;
	
	/**
     * The tier.
     */
	@SerializedName("Class")
	public Integer tier;
	
	/**
     * The weapon mods.
     */
	public ArrayList<String> weaponMods;
	
	/**
     * The suit module ID.
     */
	public Long suitModuleID;
}
