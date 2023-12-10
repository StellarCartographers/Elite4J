package elite.dangerous.journal.events.suit;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class UpgradeSuit extends Event
{

    private String name;

    private long   suitID;

    private int    suitClass;

    private long   cost;
}
