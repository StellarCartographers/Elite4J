package elite.dangerous.journal.events.stationservices;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.ModuleItem;
import lombok.EliteObject;

@EliteObject
public class MassModuleStore extends Event
{

    private long             marketID;

    private String           ship;

    private int              shipID;

    private List<ModuleItem> items;

}
