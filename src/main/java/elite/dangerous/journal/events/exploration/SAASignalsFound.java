package elite.dangerous.journal.events.exploration;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.ssa.Genus;
import elite.dangerous.model.ssa.Signal;
import lombok.EliteObject;

@EliteObject
public class SAASignalsFound extends Event
{
    private String       bodyName;

    private long         systemAddress;

    private long         bodyID;

    private List<Signal> signals;

    private List<Genus>  genuses;

    public List<String> genuses()
    {
        return genuses.stream().map(Genus::name).toList();
    }
}
