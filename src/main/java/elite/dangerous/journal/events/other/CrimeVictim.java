package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CrimeVictim extends Event
{

    private String offender;

    private String crimeType;

    private String fineOrBounty;

}
