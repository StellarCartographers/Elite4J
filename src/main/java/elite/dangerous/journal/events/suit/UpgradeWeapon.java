package elite.dangerous.journal.events.suit;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class UpgradeWeapon extends Event
{

    private String name;

    private long   suitModuleID;

    private int    weaponClass;

    private long   cost;
}
