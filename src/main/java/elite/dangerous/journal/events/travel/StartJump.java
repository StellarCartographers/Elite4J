package elite.dangerous.journal.events.travel;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class StartJump extends Event
{

    public static final String JUMP_TYPE_HYPERSPACE  = "Hyperspace";

    public static final String JUMP_TYPE_SUPERCRUISE = "Supercruise";

    private String             jumpType, starSystem, starClass;

    private long               systemAddress;

}
