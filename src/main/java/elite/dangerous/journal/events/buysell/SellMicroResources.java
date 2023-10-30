package elite.dangerous.journal.events.buysell;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.journal.models.MicroResource;

public class SellMicroResources extends Event
{

    public List<MicroResource> microResources;

    public long price;

    public long marketID;
}
