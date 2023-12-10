package elite.dangerous.journal.events.buysell;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class SellSuit extends Event
{
    private String name;

    private long   price;

    private long   suitID;
}
