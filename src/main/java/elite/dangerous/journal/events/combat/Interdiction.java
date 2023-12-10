package elite.dangerous.journal.events.combat;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class Interdiction extends Event
{
    private boolean success, isPlayer;

    private String  interdicted, faction, power;

    private int     combatRank;

}
