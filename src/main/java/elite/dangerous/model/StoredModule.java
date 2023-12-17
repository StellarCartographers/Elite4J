package elite.dangerous.model;

import lombok.EliteObject;

@EliteObject
public class StoredModule
{
    private String  name, starSystem;
    private int     storageSlot;
    private long    marketID, transferCost, transferTime, buyPrice;
    private boolean hot;
}
