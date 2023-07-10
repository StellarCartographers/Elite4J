package elite.dangerous.base;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

/**
 * The Class Event.
 */
public abstract class Event {

	/**
     * The timestamp.
     */
	@SerializedName("timestamp")
	public Date timestamp;
	
	/**
     * The type.
     */
	@SerializedName("event")
	public String type;
}
