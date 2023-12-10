package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.TradeData;
import lombok.EliteObject;

@EliteObject
public class MaterialTrade extends Event
{

    private long     marketID;

    private String   traderType;

    public TradeData paid;

    public TradeData received;

}
