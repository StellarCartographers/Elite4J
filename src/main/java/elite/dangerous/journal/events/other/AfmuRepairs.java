package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class AfmuRepairs extends Event
{

    private String  module;

    private boolean fullyRepaired;

    public float    health;

}
