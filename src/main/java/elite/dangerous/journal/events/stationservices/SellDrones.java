package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.Event;

public class SellDrones extends Event
{

    public String type;

    public int count;

    public long sellPrice, totalSale;

}