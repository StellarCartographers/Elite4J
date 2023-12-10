package elite.dangerous.journal.events.stationservices;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.PriceItem;
import lombok.EliteObject;

@EliteObject
public class Shipyard extends Event
{

    private long            marketID;

    private String          stationName, starSystem;

    private boolean         horizons;

    private boolean         allowCobraMkIV;

    private List<PriceItem> priceList;
}
