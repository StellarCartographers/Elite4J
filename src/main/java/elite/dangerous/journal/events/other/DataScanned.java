package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;

public class DataScanned extends Event
{

    public static final String[] TYPES = {"DataLink", "DataPoint", "ListeningPost", "AbandonedDatalog", "WreckedShip"};

    public String type;

}
