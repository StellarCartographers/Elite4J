package elite.dangerous.journal.events.travel;

import elite.dangerous.journal.Event;

public class StartJump extends Event
{

    public static final String JUMP_TYPE_HYPERSPACE = "Hyperspace";

    public static final String JUMP_TYPE_SUPERCRUISE = "Supercruise";

    public String jumpType, starSystem, starClass;

    public long systemAddress;

}
