package elite.dangerous.journal.events.backpack;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.MicroResource;
import elite.dangerous.model.enums.MicroResourceCategory;
import lombok.EliteObject;

@EliteObject
public class TradeMicroResources extends Event
{

    private List<MicroResource>   offered;

    private String                received;

    private int                   count;

    private long                  marketID;

    private MicroResourceCategory category;
}
