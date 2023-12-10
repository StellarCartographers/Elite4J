package elite.dangerous.journal.events.other;

import java.util.List;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class WingJoin extends Event
{

    private List<String> others;

}
