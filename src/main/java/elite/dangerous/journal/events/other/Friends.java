package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;

public class Friends extends Event
{

    public static final String[] STATUS = {"Requested", "Declined", "Added", "Lost", "Offline", "Online"};

    public String status;

    public String name;

}
