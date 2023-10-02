package elite.dangerous.journal.events.exploration;

import java.util.List;

import elite.dangerous.journal.Event;
import elite.dangerous.journal.models.SAASignal;

public class FSSBodySignals extends Event
{

    public long systemAddress;

    public String bodyName;

    public int bodyID;

    public List<SAASignal> signals;

}
