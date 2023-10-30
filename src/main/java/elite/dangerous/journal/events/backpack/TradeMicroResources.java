package elite.dangerous.journal.events.backpack;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.journal.models.MicroResource;
import elite.dangerous.journal.models.enums.MicroResourceCategory;

public class TradeMicroResources extends Event
{

    public List<MicroResource> offered;

    public String received;

    public int count;

    public long marketID;

    public MicroResourceCategory category;
}
