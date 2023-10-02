package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.Event;

public class CargoDepot extends Event
{

    public long missionID;

    public long startMarketID;

    public long endMarketID;

    public int count;

    public int itemCollected;

    public int itemsDelivered;

    public int totalItemsToDeliver;

    public String updateType;

    public String cargoType;

    public double progress;

}
