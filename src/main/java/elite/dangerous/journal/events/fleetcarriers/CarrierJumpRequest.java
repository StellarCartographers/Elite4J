package elite.dangerous.journal.events.fleetcarriers;

import elite.dangerous.journal.base.Event;

public class CarrierJumpRequest extends Event
{

    public long carrierID;

    public String systemName;

    public String body;

    public long systemAddress;

    public int bodyID;

    public String departureTime;

}
