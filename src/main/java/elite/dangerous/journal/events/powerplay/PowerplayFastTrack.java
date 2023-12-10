package elite.dangerous.journal.events.powerplay;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class PowerplayFastTrack extends Event
{

    private String power;

    private int    cost;

}
