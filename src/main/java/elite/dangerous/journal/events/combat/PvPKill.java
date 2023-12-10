package elite.dangerous.journal.events.combat;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class PvPKill extends Event
{
    private String victim;

    private int    combatRank;

}
