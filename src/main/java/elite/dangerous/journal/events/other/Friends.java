package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class Friends extends Event
{

    public static final String[] STATUS = {"Requested", "Declined", "Added", "Lost", "Offline", "Online"};

    private String               status;

    private String               name;

}
