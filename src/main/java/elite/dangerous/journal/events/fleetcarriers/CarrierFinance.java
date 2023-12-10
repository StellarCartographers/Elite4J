package elite.dangerous.journal.events.fleetcarriers;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CarrierFinance extends Event
{

    private double taxRate, reservePercent;

    private long   carrierID, carrierBalance, reserveBalance, availableBalance;

}
