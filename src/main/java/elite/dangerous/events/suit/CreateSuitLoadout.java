package elite.dangerous.events.suit;

import java.util.ArrayList;

import elite.dangerous.Trigger;
import elite.dangerous.base.Suit;
import elite.dangerous.models.LoadoutModule;

/**
 * The Class CreateSuitLoadout.
 */
public class CreateSuitLoadout extends Suit implements Trigger {
	
	/**
     * The suit mods.
     */
	public ArrayList<String> suitMods;
	
	/**
     * The modules.
     */
	public ArrayList<LoadoutModule> modules;
}
