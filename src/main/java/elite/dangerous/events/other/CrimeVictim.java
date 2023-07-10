package elite.dangerous.events.other;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CrimeVictim.
 */
public class CrimeVictim extends Event implements Trigger {

	/**
     * The offender.
     */
	public String offender;
	
	/**
     * The crime type.
     */
	public String crimeType;
	
	/**
     * The fine or bounty.
     */
	@SerializedName("Fine_or_Bounty")
	public String fineOrBounty;

}
