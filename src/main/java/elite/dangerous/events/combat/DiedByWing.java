package elite.dangerous.events.combat;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.models.Killer;

/**
 * The Class DiedByWing.
 */
public class DiedByWing extends Died implements Trigger {
	
	/**
     * The killers.
     */
	public List<Killer> killers;
}
