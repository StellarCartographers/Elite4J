package elite.dangerous.journal.events.travel;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class SupercruiseEntry extends Event
{

    private String  starSystem;

    private boolean taxi;

    private boolean multicrew;

    private long    systemAddress;

}
