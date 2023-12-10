package elite.dangerous.capi.modal.fc.orders;

import lombok.EliteObject;

@EliteObject
public class MicroResourcePurchase implements Purchase
{
    private String  name;
    private String  locName;
    private int     total;
    private int     outstanding;
    private int     price;
}