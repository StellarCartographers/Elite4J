package elite.dangerous.capi.modal.fc.orders;

import lombok.EliteObject;

@EliteObject
public class MicroResourceSale implements Sale
{
    private String  name;
    private String  locName;
    private int     stock;
    private int     price;
}