package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CommitCrime extends Event
{

    private String crimeType;

    private String faction;

    private String victim;

    private int    bounty;

    private int    fine;

}
