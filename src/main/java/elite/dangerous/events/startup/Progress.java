package elite.dangerous.events.startup;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class Progress.
 */
public class Progress extends Event implements Trigger {

	/**
     * The combat.
     */
	public Integer combat;
	
	/**
     * The trade.
     */
	public Integer trade;
	
	/**
     * The explore.
     */
	public Integer explore;
	
	/**
     * The soldier.
     */
	public Integer soldier;
	
	/**
     * The exobiologist.
     */
	public Integer exobiologist;
	
	/**
     * The empire.
     */
	public Integer empire;
	
	/**
     * The federation.
     */
	public Integer federation;
	
	/**
     * The cqc.
     */
	@SerializedName("CQC")
	public Integer cqc;

}
