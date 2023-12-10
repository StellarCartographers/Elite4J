package elite.dangerous.journal.events.exploration;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class MaterialDiscarded extends Event
{

    private String category, name;

    private int    count;

}
