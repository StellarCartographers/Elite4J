package elite.dangerous.journal.events.suit;

import java.util.ArrayList;

import elite.dangerous.journal.base.Suit;
import elite.dangerous.model.LoadoutModule;
import lombok.EliteObject;

/**
 * The Class SuitLoadout.
 */
@EliteObject
public class SuitLoadout extends Suit
{

    /**
     * The suit mods.
     */
    public ArrayList<String>        suitMods;

    /**
     * The modules.
     */
    public ArrayList<LoadoutModule> modules;
}
