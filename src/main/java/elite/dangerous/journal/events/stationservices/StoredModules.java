package elite.dangerous.journal.events.stationservices;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.StoredModule;
import lombok.EliteObject;

@EliteObject
public class StoredModules extends Event
{

    private long               marketID;

    private String             stationName, starSystem;

    private List<StoredModule> items;

}
