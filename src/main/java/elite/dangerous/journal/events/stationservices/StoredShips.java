package elite.dangerous.journal.events.stationservices;

import java.util.List;

import elite.dangerous.journal.Event;
import elite.dangerous.journal.models.StoredShipHere;
import elite.dangerous.journal.models.StoredShipRemote;

public class StoredShips extends Event
{

    public String stationName, starSystem;

    public long marketID;

    public List<StoredShipHere> shipsHere;

    public List<StoredShipRemote> shipsRemote;

}
