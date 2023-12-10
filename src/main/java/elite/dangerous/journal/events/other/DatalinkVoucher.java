package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class DatalinkVoucher extends Event
{

    private long   reward;

    private String victimFaction;

    private String payeeFaction;

}
