package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class RepairDone extends Event
{

    private double hullRepaired;

    private double cockpitRepaired;

    private double corrosionRepaired;

}
