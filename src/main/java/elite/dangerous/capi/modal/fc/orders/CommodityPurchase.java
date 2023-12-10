package elite.dangerous.capi.modal.fc.orders;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EliteObject;

@EliteObject
public class CommodityPurchase implements Purchase
{
    private String  name;
    private int     total;
    private int     outstanding;
    private int     price;
    private boolean blackmarket;
    
    @JsonIgnore
    public static Legality<CommodityPurchase> Legality()
    {
        return purchase -> purchase.blackmarket();
    }
}