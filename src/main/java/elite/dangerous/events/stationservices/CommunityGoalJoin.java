package elite.dangerous.events.stationservices;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CommunityGoalJoin.
 */
public class CommunityGoalJoin extends Event implements Trigger {

	/**
     * The cgid.
     */
	@SerializedName("CGID")
	public Integer cgid;
	
	/**
     * The name.
     */
	public String name;
	
	/**
     * The system.
     */
	public String system;

}
