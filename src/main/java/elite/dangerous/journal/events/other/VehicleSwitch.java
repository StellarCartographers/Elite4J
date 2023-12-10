package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.enums.Switched;
import lombok.EliteObject;

@EliteObject
public class VehicleSwitch extends Event
{

    public Switched to;

}
