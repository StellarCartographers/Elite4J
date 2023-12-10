package elite.dangerous.journal.events.exploration;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class Screenshot extends Event
{

    private String filename, system, body;

    private int    width, height, heading;

    private double latitude, longitude, altitude;

}
