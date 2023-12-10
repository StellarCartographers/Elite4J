package elite.dangerous.journal.events.exploration;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.station.Discovered;
import lombok.EliteObject;

@EliteObject
public class MultiSellExplorationData extends Event
{

    private List<Discovered> discovered;

    private int              baseValue, totalEarnings, bonus;

}
