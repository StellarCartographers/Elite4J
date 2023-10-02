package elite.dangerous.journal.events.backpack;

import java.util.List;

import elite.dangerous.journal.Event;
import elite.dangerous.journal.models.MicroResource;

public class TransferMicroResources extends Event
{

    public List<MicroResourceTransfer> transfers;

    public static class MicroResourceTransfer extends MicroResource
    {

        public String direction;
    }
}
