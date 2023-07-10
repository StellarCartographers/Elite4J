package elite.dangerous.base;

import com.google.gson.annotations.SerializedName;

/**
 * The Class Dock.
 */
public abstract class Dock extends Event {

	/**
     * The id.
     */
	@SerializedName("ID")
	public String id;
}
