package elite.dangerous.journal.events.other;

import elite.dangerous.journal.Event;

public class DataScanned extends Event
{

    public static final String[] TYPES = {"DataLink", "DataPoint", "ListeningPost", "AbandonedDatalog", "WreckedShip"};

    public String type;

}
