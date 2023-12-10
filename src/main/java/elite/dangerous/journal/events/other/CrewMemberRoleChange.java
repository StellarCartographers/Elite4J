package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CrewMemberRoleChange extends Event
{

    private String crew;

    private String role;

}
