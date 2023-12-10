package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class Resurrect extends Event
{

    private String  option;

    private long    cost;

    private boolean bankrupt;

}
