package elite.dangerous.journal.events.travel;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class Liftoff extends Event
{

    private boolean playerControlled;

    private double  longitude, latitude;

    private String  nearestDestination;

}
