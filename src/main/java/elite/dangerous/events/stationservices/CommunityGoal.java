package elite.dangerous.events.stationservices;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CommunityGoal.
 */
public class CommunityGoal extends Event implements Trigger {

	/**
     * The cgid.
     */
	@SerializedName("CGID")
	public Integer cgid;
	
	/**
     * The player contribution.
     */
	public Integer playerContribution;
	
	/**
     * The num contributors.
     */
	public Integer numContributors;
	
	/**
     * The top rank size.
     */
	public Integer topRankSize;
	
	/**
     * The player percentile band.
     */
	public Integer playerPercentileBand;
	
	/**
     * The bonus.
     */
	public Integer bonus;
	
	/**
     * The title.
     */
	public String title;
	
	/**
     * The system name.
     */
	public String systemName;
	
	/**
     * The market name.
     */
	public String marketName;
	
	/**
     * The tier reached.
     */
	public String tierReached;
	
	/**
     * The expiry.
     */
	public Date expiry;
	
	/**
     * The is complete.
     */
	public Boolean isComplete;
	
	/**
     * The player in top rank.
     */
	public Boolean playerInTopRank;

}
