package elite.dangerous.journal.events.startup;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.PassengerRecord;
import lombok.EliteObject;

@EliteObject
public class Passengers extends Event
{

    private List<PassengerRecord> manifest;

}
