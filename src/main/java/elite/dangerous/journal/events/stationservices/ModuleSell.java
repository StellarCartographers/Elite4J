package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;

public class ModuleSell extends Event
{

    public String slot;

    public String sellItem;

    public String ship;

    public long sellPrice, marketID;

    public int shipID;

}
