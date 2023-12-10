package elite.dangerous.capi.modal.fc;

import elite.dangerous.fdev.FDevID;
import lombok.EliteObject;

@EliteObject
public class CarrierCommodity
{
    private FDevID id;
    private String categoryname;
    private String name;
    private int    stock;
    private int    buyPrice;
    private int    sellPrice;
    private int    demand;
    private String legality;
    private int    meanPrice;
    private int    demandBracket;
    private int    stockBracket;
    private String locName;
}
