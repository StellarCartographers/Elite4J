package elite.dangerous.journal.events.exploration;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CodexEntry extends Event
{
    private String   name;

    private String   subCategory;

    private String   category;

    private String   region;

    private String   system;

    private int      entryID;

    private long     systemAddress;

    private boolean  isNewEntry;

    private boolean  newTraitsDiscovered;

    private String[] traits;

    private String   nearestDestination;
}
