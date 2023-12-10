package elite.dangerous.journal.events.buysell;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.enums.MicroResourceCategory;
import lombok.EliteObject;

@EliteObject
public class BuyMicroResources extends Event
{
    private String                name;

    private MicroResourceCategory category;

    private int                   count;

    private long                  price;

    private long                  marketID;
}
