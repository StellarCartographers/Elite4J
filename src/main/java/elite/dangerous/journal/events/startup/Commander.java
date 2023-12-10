package elite.dangerous.journal.events.startup;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class Commander extends Event
{

    private String name;

    private String fid;

}
