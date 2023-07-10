package elite.dangerous.events.other;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class KickCrewMember.
 */
public class KickCrewMember extends Event implements Trigger {

	/**
     * The crew.
     */
	public String crew;
	
	/**
     * The on crime.
     */
	public Boolean onCrime;

}
