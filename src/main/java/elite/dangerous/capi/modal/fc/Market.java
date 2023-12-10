package elite.dangerous.capi.modal.fc;

import java.util.List;

import elite.dangerous.fdev.FDevID;
import lombok.EliteObject;

@EliteObject
public class Market
{
    private FDevID                 id;
    private String                 name;
    private final String           outpostType = "fleetcarrier";
    private List<Object>           imported;
    private List<Object>           exported;
    private ServiceStates          services;
    private final Economies        economies   = new Economies();
    private Object                 prohibited;
    private List<CarrierCommodity> commodities;
}
