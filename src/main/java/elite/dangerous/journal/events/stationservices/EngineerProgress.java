package elite.dangerous.journal.events.stationservices;

import java.util.List;

import elite.dangerous.journal.Event;
import elite.dangerous.journal.models.engineer.Engineer;

public class EngineerProgress extends Event
{

    public List<Engineer> engineers;

    public int rank;

    public double rankProgress;

}
