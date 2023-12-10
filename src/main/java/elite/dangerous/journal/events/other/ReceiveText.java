package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ReceiveText extends Event
{
    private String from;

    private String message;

    private String channel;
}
