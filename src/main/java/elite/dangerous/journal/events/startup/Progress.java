package elite.dangerous.journal.events.startup;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class Progress extends Event
{

    private int combat;

    private int trade;

    private int explore;

    private int soldier;

    private int exobiologist;

    private int empire;

    private int federation;

    private int cqc;

}
