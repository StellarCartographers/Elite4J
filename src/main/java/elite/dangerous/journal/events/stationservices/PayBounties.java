package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class PayBounties extends Event
{

    private long   amount;

    private String faction;

    private int    shipID, brokerPercentage;

}
