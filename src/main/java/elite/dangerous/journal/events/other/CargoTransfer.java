package elite.dangerous.journal.events.other;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.inventory.Transfer;
import lombok.EliteObject;

@EliteObject
public class CargoTransfer extends Event
{

    private List<Transfer> transfers;

}
