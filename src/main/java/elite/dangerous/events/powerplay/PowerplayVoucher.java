package elite.dangerous.events.powerplay;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class PowerplayVoucher.
 */
public class PowerplayVoucher extends Event implements Trigger {

	/**
     * The power.
     */
	public String power;
	
	/**
     * The systems.
     */
	public List<String> systems;

}
