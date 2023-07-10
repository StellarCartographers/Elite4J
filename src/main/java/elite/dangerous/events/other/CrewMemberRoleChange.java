package elite.dangerous.events.other;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CrewMemberRoleChange.
 */
public class CrewMemberRoleChange extends Event implements Trigger {

	/**
     * The crew.
     */
	public String crew;
	
	/**
     * The role.
     */
	public String role;

}
