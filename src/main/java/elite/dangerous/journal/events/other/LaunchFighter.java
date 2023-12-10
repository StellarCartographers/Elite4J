package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class LaunchFighter extends Event
{

    private String  loadout;

    private int     id;

    private boolean playerControlled;

}
