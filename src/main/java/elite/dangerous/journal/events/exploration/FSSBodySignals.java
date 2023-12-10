package elite.dangerous.journal.events.exploration;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.SAASignal;
import lombok.EliteObject;

@EliteObject
public class FSSBodySignals extends Event
{

    private long            systemAddress;

    private String          bodyName;

    private int             bodyID;

    private List<SAASignal> signals;

}
