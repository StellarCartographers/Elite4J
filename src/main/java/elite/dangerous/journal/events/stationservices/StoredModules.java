package elite.dangerous.journal.events.stationservices;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.journal.models.StoredModule;

public class StoredModules extends Event
{

    public long marketID;

    public String stationName, starSystem;

    public List<StoredModule> items;

}
