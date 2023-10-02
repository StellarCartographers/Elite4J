package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.Event;
import elite.dangerous.journal.models.TradeData;

public class MaterialTrade extends Event
{

    public long marketID;

    public String traderType;

    public TradeData paid;

    public TradeData received;

}
