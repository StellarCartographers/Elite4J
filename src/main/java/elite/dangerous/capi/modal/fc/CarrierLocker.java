package elite.dangerous.capi.modal.fc;

import java.util.List;

import lombok.EliteObject;

@EliteObject
public class CarrierLocker
{
    private List<LockerItem> assets;
    private List<LockerItem> goods;
    private List<LockerItem> data;
}
