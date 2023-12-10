package elite.dangerous.journal.events.combat;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class FactionKillBond extends Event
{
    private int    reward;

    private String awardingFaction;

    private String victimFaction;
}
