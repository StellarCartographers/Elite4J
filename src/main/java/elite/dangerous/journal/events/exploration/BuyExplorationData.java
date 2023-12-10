package elite.dangerous.journal.events.exploration;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class BuyExplorationData extends Event
{
    private String system;

    private int    cost;
}
