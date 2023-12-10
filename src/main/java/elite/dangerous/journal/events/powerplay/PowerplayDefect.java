package elite.dangerous.journal.events.powerplay;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class PowerplayDefect extends Event
{

    private String fromPower;

    private String toPower;

}
