package elite.dangerous.journal.events.buysell;

import java.util.ArrayList;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.BioDataItem;
import lombok.EliteObject;

@EliteObject
public class SellOrganicData extends Event
{
    private int                    marketID;

    private ArrayList<BioDataItem> bioData;
}
