package elite.dangerous.model;

import lombok.EliteObject;

@EliteObject public class StoredShipRemote extends StoredShipHere
{

    private String starSystem;

    private long shipMarketID, transferTime, transferPrice;
}
