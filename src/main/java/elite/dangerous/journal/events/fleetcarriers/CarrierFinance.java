package elite.dangerous.journal.events.fleetcarriers;

import elite.dangerous.journal.Event;

public class CarrierFinance extends Event
{

    public double taxRate, reservePercent;

    public long carrierID, carrierBalance, reserveBalance, availableBalance;

}
