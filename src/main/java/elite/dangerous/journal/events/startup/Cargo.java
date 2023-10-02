package elite.dangerous.journal.events.startup;

import java.util.List;

import elite.dangerous.journal.Event;
import elite.dangerous.journal.models.CargoItem;

public class Cargo extends Event
{

    public String vessel;

    public int count;

    public List<CargoItem> inventory;
}
