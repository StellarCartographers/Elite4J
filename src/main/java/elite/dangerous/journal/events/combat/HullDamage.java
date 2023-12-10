package elite.dangerous.journal.events.combat;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class HullDamage extends Event
{
    private double  health;

    private boolean playerPilot;

    private boolean fighter;

}
