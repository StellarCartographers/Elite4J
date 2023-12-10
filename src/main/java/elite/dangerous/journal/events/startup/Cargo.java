package elite.dangerous.journal.events.startup;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.CargoItem;
import lombok.EliteObject;

@EliteObject
public class Cargo extends Event
{

    private String          vessel;

    private int             count;

    private List<CargoItem> inventory;
}
