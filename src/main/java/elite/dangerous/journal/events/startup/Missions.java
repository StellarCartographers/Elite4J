package elite.dangerous.journal.events.startup;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.Mission;
import lombok.EliteObject;

@EliteObject
public class Missions extends Event
{

    private List<Mission> active;

    private List<Mission> failed;

    private List<Mission> complete;

}
