package elite.dangerous.journal.events.exploration;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.journal.models.station.Discovered;

public class MultiSellExplorationData extends Event
{

    public List<Discovered> discovered;

    public int baseValue, totalEarnings, bonus;

}
