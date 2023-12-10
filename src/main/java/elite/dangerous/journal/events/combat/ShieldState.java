package elite.dangerous.journal.events.combat;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class ShieldState extends Event
{
    private boolean shieldsUp;
}
