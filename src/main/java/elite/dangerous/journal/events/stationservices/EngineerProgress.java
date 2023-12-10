package elite.dangerous.journal.events.stationservices;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.engineer.Engineer;
import lombok.EliteObject;

@EliteObject
public class EngineerProgress extends Event
{

    private List<Engineer> engineers;

    private int            rank;

    private double         rankProgress;

}
