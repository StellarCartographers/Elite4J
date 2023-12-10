package elite.dangerous.journal.events.backpack;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.MicroResourceTransfer;
import lombok.EliteObject;

@EliteObject
public class TransferMicroResources extends Event
{
    private List<MicroResourceTransfer> transfers;
}
