package elite.dangerous.journal.events.combat;

import elite.dangerous.journal.Event;

public class Interdicted extends Event
{

    public boolean submitted, isPlayer;

    public String interdictor, faction, power;

    public int combatRank;

}
