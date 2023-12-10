package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CargoDepot extends Event
{
    private long   missionID;

    private long   startMarketID;

    private long   endMarketID;

    private int    count;

    private int    itemCollected;

    private int    itemsDelivered;

    private int    totalItemsToDeliver;

    private String updateType;

    private String cargoType;

    private double progress;

}
