package elite.dangerous.journal.events.combat;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class Interdicted extends Event
{
    private boolean submitted, isPlayer;

    private String  interdictor, faction, power;

    private int     combatRank;

}
