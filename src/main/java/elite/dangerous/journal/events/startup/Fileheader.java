package elite.dangerous.journal.events.startup;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class Fileheader extends Event
{

    private int     part;

    private String  language;

    private boolean odyssey;

    private String  gameversion;

    private String  build;
}
