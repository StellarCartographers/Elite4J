package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class KickCrewMember extends Event
{

    private String  crew;

    private boolean onCrime;

}
