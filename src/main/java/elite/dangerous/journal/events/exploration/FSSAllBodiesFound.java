package elite.dangerous.journal.events.exploration;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class FSSAllBodiesFound extends Event
{

    private String systemName;

    private long   systemAddress;

    private int    count;

}
