package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ShipyardNew extends Event
{

    private String shipType;

    private int    newShipID;

}
