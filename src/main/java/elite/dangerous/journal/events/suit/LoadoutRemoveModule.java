package elite.dangerous.journal.events.suit;

import java.util.ArrayList;

import elite.dangerous.journal.base.Suit;
import lombok.EliteObject;

@EliteObject
public class LoadoutRemoveModule extends Suit
{

    private String           slotName;

    private String           moduleName;

    private int              tier;

    public ArrayList<String> weaponMods;

    private long             suitModuleID;
}
