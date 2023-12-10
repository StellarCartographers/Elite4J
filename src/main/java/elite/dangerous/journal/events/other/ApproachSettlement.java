package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ApproachSettlement extends Event
{

    private String name;

    private String bodyName;

    private int    bodyID;

    private double latitude;

    private double longitude;

    private long   marketID;

    private long   systemAddress;

}
