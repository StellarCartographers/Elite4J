package elite.dangerous.events.other;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class Promotion.
 */
public class Promotion extends Event implements Trigger {

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
     * The cqc.
     */
	@SerializedName("CQC")
	public Integer cqc;
	
	/**
     * The federation.
     */
	public Integer federation;
	
	/**
     * The empire.
     */
	public Integer empire;

}
