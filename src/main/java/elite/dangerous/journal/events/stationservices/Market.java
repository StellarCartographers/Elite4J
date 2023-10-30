package elite.dangerous.journal.events.stationservices;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.journal.models.market.MarketItem;

public class Market extends Event
{

    public String stationName;

    public String starSystem;

    public String stationType;

    public String carrierDockingAccess;

    public int marketID;

    public List<MarketItem> items;
}
