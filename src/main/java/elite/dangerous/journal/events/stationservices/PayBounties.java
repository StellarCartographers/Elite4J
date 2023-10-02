package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.Event;

public class PayBounties extends Event
{

    public long amount;

    public String faction, factionLocalised;

    public int shipID, brokerPercentage;

}
