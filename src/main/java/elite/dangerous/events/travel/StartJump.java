package elite.dangerous.events.travel;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class StartJump.
 */
public class StartJump extends Event implements Trigger {

	/**
     * The Constant JUMP_TYPE_HYPERSPACE.
     */
	public static final String JUMP_TYPE_HYPERSPACE = "Hyperspace";
	
	/**
     * The Constant JUMP_TYPE_SUPERCRUISE.
     */
	public static final String JUMP_TYPE_SUPERCRUISE = "Supercruise";

	/**
     * The star class.
     */
	public String jumpType, starSystem, starClass;
	
	/**
     * The system address.
     */
	public Long systemAddress;

}
