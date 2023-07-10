package elite.dangerous.events.other;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class USSDrop.
 */
public class USSDrop extends Event implements Trigger {

	/**
     * The uss type.
     */
	@SerializedName("USSType")
	public String ussType;
	
	/**
     * The uss type localised.
     */
	@SerializedName("USSType_Localised")
	public String ussTypeLocalised;
	
	/**
     * The uss threat.
     */
	@SerializedName("USSThreat")
	public Integer ussThreat;

}
