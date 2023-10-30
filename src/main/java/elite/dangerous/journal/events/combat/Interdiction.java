package elite.dangerous.journal.events.combat;

import elite.dangerous.journal.base.Event;

public class Interdiction extends Event
{

    public boolean success, isPlayer;

    public String interdicted, faction, power;

    public int combatRank;

}
