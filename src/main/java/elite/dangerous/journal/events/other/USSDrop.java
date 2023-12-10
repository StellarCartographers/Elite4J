package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class USSDrop extends Event
{
    private String ussType;

    private int    ussThreat;
}
