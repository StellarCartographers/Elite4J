package elite.dangerous.journal.events.powerplay;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class PowerplayVote extends Event
{

    private String power;

    private int    votes;

    private String system;

}
