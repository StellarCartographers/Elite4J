package elite.dangerous.models;

import com.google.gson.annotations.SerializedName;

/**
 * The Class PassengerRecord.
 */
public class PassengerRecord {

	/**
     * The type.
     */
	public String type;
	
	/**
     * The count.
     */
	public Integer count;
	
	/**
     * The vip.
     */
	@SerializedName("VIP")
	public Boolean vip;
	
	/**
     * The wanted.
     */
	public Boolean wanted;
	
	/**
     * The mission ID.
     */
	public Long missionID;
}
