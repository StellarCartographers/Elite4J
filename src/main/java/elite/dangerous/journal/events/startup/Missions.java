package elite.dangerous.journal.events.startup;

import java.util.List;

import elite.dangerous.journal.Event;
import elite.dangerous.journal.models.Mission;

public class Missions extends Event
{

    public List<Mission> active;

    public List<Mission> failed;

    public List<Mission> complete;

}
