package elite.dangerous.journal.events.startup;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class Powerplay extends Event
{

    private String power;

    private int    rank;

    private int    merits;

    private int    votes;

    private int    timePledged;

}
