package elite.dangerous.journal.events.stationservices;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class EngineerContribution extends Event
{

    private String engineer;

    private String type;

    private String commodity;

    private String faction;

    private String material;

    private int    engineerID;

    private int    quantity;

    private int    totalQuantity;

}
