package elite.dangerous.journal.events.stationservices;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.StoredShipHere;
import elite.dangerous.model.StoredShipRemote;
import lombok.EliteObject;

@EliteObject
public class StoredShips extends Event
{

    private String                 stationName, starSystem;

    private long                   marketID;

    private List<StoredShipHere>   shipsHere;

    private List<StoredShipRemote> shipsRemote;

}
