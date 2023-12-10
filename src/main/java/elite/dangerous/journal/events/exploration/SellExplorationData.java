package elite.dangerous.journal.events.exploration;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class SellExplorationData extends Event
{

    private String[] systems, discovered;

    private int      baseValue, bonus, totalEarnings;

}
