package elite.dangerous.journal.events.exploration;

import elite.dangerous.journal.base.Event;

public class CodexEntry extends Event
{

    public String name;

    public String subCategory;

    public String category;

    public String region;

    public String system;

    public int entryID;

    public long systemAddress;

    public boolean isNewEntry;

    public boolean newTraitsDiscovered;

    public String[] traits;

    public String nearestDestination;
}
