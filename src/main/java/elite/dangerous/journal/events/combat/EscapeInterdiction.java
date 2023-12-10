package elite.dangerous.journal.events.combat;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class EscapeInterdiction extends Event
{
    private String  interdictor;

    private boolean isPlayer;

}
