package elite.dangerous.journal.events.powerplay;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class PowerplaySalary extends Event
{

    private String power;

    private int    amount;

}
