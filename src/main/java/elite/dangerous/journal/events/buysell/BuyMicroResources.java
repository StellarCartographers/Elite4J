package elite.dangerous.journal.events.buysell;

import elite.dangerous.journal.base.Event;
import elite.dangerous.journal.models.enums.MicroResourceCategory;

public class BuyMicroResources extends Event
{

    public String name;

    public MicroResourceCategory category;

    public int count;

    public long price;

    public long marketID;
}
