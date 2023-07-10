package elite.dangerous.events.other;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class RepairDone.
 */
public class RepairDone extends Event implements Trigger {

	/**
     * The hull repaired.
     */
	public Double hullRepaired;
	
	/**
     * The cockpit repaired.
     */
	public Double cockpitRepaired;
	
	/**
     * The corrosion repaired.
     */
	public Double corrosionRepaired;

}
