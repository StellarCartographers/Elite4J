package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ReservoirReplenished extends Event
{

    private double fuelMain;

    private double fuelReservoir;

}
