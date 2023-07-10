package elite.dangerous.events.other;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.Module;

/**
 * The Class ModuleInfo.
 */
public class ModuleInfo extends Event implements Trigger {

	/**
     * The modules.
     */
	public List<Module> modules;

}