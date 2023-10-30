package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;

public class PayBounties extends Event
{

    public long amount;

    public String faction;

    public int shipID, brokerPercentage;

}
