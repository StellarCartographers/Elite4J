package elite.dangerous;

import elite.dangerous.base.Event;

public interface Trigger
{
    default <T extends Event> void onTriggered(EliteEventBus bus, T event)
    {
        bus.post(event);
    }
}
