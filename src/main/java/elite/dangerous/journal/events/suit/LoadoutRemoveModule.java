package elite.dangerous.journal.events.suit;

import java.util.ArrayList;

import elite.dangerous.journal.base.Suit;

public class LoadoutRemoveModule extends Suit
{

    public String slotName;

    public String moduleName;

    public int tier;

    public ArrayList<String> weaponMods;

    public long suitModuleID;
}
