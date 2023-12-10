package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class SetUserShipName extends Event
{

    private String ship;

    private int    shipID;

    private String userShipName, userShipId;

}
