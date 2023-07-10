package elite.dangerous.events.other;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class NpcCrewPaidWage.
 */
public class NpcCrewPaidWage extends Event implements Trigger {

	/**
     * The npc crew id.
     */
	public Long npcCrewId;
	
	/**
     * The npc crew name.
     */
	public String npcCrewName;
	
	/**
     * The amount.
     */
	public Integer amount;

}
