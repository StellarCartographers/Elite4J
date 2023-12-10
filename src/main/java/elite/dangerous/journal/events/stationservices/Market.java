package elite.dangerous.journal.events.stationservices;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.market.MarketItem;
import lombok.EliteObject;

@EliteObject
public class Market extends Event
{

    private String           stationName;

    private String           starSystem;

    private String           stationType;

    private String           carrierDockingAccess;

    private int              marketID;

    private List<MarketItem> items;
}
