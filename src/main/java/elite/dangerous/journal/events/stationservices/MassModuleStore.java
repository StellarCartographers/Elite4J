package elite.dangerous.journal.events.stationservices;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.journal.models.ModuleItem;

public class MassModuleStore extends Event
{

    public long marketID;

    public String ship;

    public int shipID;

    public List<ModuleItem> items;

}
