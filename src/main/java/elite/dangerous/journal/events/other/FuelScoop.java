package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class FuelScoop extends Event
{

    public float scooped;

    private int  total;

}
