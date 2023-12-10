package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class Promotion extends Event
{

    private int combat;

    private int trade;

    private int explore;

    private int cqc;

    private int federation;

    private int empire;

}
