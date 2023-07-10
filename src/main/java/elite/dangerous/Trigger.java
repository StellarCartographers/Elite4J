package elite.dangerous;

import elite.dangerous.base.Event;

public interface Trigger
{
    default <T extends Event> void onTriggered(T event)
    {
        EliteAPI.EVENT_BUS.post(event);
    }
}
