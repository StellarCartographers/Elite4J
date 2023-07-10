package elite.dangerous.events.startup;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class LoadGame.
 */
public class LoadGame extends Event implements Trigger {

	/**
     * The commander.
     */
	public String commander;
	
	/**
     * The fid.
     */
	@SerializedName("FID")
	public String fid;
	
	/**
     * The ship.
     */
	public String ship;
	
	/**
     * The ship localised.
     */
	public String shipLocalised;
	
	/**
     * The ship name.
     */
	public String shipName;
	
	/**
     * The ship ident.
     */
	public String shipIdent;
	
	/**
     * The game mode.
     */
	public String gameMode;
	
	/**
     * The group.
     */
	public String group;
	
	/**
     * The ship ID.
     */
	public Integer shipID;
	
	/**
     * The fuel level.
     */
	public Double fuelLevel;
	
	/**
     * The fuel capacity.
     */
	public Double fuelCapacity;
	
	/**
     * The credits.
     */
	public Long credits;
	
	/**
     * The loan.
     */
	public Long loan;
	
	/**
     * The horizons.
     */
	public Boolean horizons;
	
	/**
     * The start landed.
     */
	public Boolean startLanded;
	
	/**
     * The start dead.
     */
	public Boolean startDead;

}
