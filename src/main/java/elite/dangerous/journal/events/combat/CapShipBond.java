package elite.dangerous.journal.events.combat;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CapShipBond extends Event
{
    private String victimFaction;

    private String awardingFaction;

    private int    reward;

}
