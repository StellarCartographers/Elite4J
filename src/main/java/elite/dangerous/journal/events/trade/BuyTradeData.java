package elite.dangerous.journal.events.trade;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class BuyTradeData extends Event
{

    private String system;

    private int    cost;
}
