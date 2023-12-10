package elite.dangerous.journal.events.travel;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class SupercruiseExit extends Event
{

    private String starSystem;

    private String body;

    private String bodyType;

    private int    bodyID;

}
