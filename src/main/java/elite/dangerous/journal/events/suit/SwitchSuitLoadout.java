package elite.dangerous.journal.events.suit;

import java.util.ArrayList;

import elite.dangerous.journal.base.Suit;
import elite.dangerous.model.LoadoutModule;
import lombok.EliteObject;

@EliteObject
public class SwitchSuitLoadout extends Suit
{

    public ArrayList<String>        suitMods;

    public ArrayList<LoadoutModule> modules;
}
