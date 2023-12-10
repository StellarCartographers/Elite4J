package elite.dangerous.journal.events.travel;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class Touchdown extends Event
{

    private boolean playerControlled;

    private double  latitude, longitude;

    private String  nearestDestination;
}
