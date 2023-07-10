package elite.dangerous.events.exploration;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class FSSSignalDiscovered.
 */
public class FSSSignalDiscovered extends Event implements Trigger {

	/**
     * The signal name.
     */
	public String signalName;
	
	/**
     * The signal name localised.
     */
	public String signalNameLocalised;
	
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
     * The spawning state.
     */
	public String spawningState;
	
	/**
     * The spawning state localised.
     */
	public String spawningStateLocalised;
	
	/**
     * The spawning faction.
     */
	public String spawningFaction;
	
	/**
     * The spawning faction localised.
     */
	public String spawningFactionLocalised;
	
	/**
     * The threat level.
     */
	public Integer threatLevel;
	
	/**
     * The system address.
     */
	public Long systemAddress;
	
	/**
     * The time remaining.
     */
	public Double timeRemaining;
	
	/**
     * The is station.
     */
	public Boolean isStation;

}
