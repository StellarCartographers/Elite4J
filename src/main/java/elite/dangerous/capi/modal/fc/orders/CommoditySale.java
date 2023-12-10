package elite.dangerous.capi.modal.fc.orders;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EliteObject;

@EliteObject
public class CommoditySale implements Sale
{
    private String  name;
    private int     stock;
    private int     price;
    private boolean blackmarket;
    
    @JsonIgnore
    public static Legality<CommoditySale> Legality()
    {
        return sale -> sale.blackmarket();
    }
}