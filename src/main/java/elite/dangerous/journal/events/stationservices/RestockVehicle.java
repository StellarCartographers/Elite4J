package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class RestockVehicle extends Event
{

    private String type, loadout;

    private long   cost;

    private int    count;

}
