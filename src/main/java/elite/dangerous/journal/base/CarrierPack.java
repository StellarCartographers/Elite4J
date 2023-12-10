package elite.dangerous.journal.base;

import elite.dangerous.model.carrier.Operation;
import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public abstract class CarrierPack extends Event
{
    private int       carrierID;

    private Operation operation;

    private String    packTheme;

    private int       packTier;

    private int       cost;
}
