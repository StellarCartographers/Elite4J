package elite.dangerous.journal.events.buysell;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.MicroResource;
import lombok.EliteObject;

@EliteObject
public class SellMicroResources extends Event
{

    private List<MicroResource> microResources;

    private long                price;

    private long                marketID;
}
