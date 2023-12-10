package elite.dangerous.journal.events.fleetcarriers;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CarrierDepositFuel extends Event
{

    private int  total, amount;

    private long carrierID;

}
