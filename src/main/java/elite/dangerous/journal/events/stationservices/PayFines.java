package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class PayFines extends Event
{

    private long    amount;

    private int     shipID;

    private boolean allFines;

}
