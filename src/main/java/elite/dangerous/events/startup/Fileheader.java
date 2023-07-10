package elite.dangerous.events.startup;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class Fileheader.
 */
public class Fileheader extends Event implements Trigger {
	
	/**
     * The part.
     */
	public Integer part;
	
	/**
     * The language.
     */
	public String language;
	
	/**
     * The odyssey.
     */
	@SerializedName("Odyssey")
	public Boolean odyssey;
	
	/**
     * The gameversion.
     */
	public String gameversion;
	
	/**
     * The build.
     */
	public String build;
}
