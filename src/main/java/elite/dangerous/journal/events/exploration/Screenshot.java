package elite.dangerous.journal.events.exploration;

import elite.dangerous.journal.base.Event;

public class Screenshot extends Event
{

    public String filename, system, body;

    public int width, height, heading;

    public double latitude, longitude, altitude;

}
