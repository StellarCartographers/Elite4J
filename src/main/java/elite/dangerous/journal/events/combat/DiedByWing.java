package elite.dangerous.journal.events.combat;

import java.util.List;

import elite.dangerous.model.Killer;
import lombok.EliteObject;

@EliteObject
public class DiedByWing extends Died
{
    private List<Killer> killers;
}
