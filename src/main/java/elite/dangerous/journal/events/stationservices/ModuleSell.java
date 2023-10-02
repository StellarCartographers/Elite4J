package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.Event;

public class ModuleSell extends Event
{

    public String slot;

    public String sellItem;

    public String sellItemLocalised;

    public String ship;

    public long sellPrice, marketID;

    public int shipID;

}
