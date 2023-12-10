package elite.dangerous.capi.modal.fc;

import elite.dangerous.fdev.FDevID;
import lombok.EliteObject;

@EliteObject
public class LockerItem
{
    private FDevID id;
    private int    quantity;
    private String name;
    private String locName;
}
