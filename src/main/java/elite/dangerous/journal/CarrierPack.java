package elite.dangerous.journal;

import elite.dangerous.journal.models.carrier.Operation;

public abstract class CarrierPack extends Event
{
    public int carrierID;

    public Operation operation;

    public String packTheme;

    public int packTier;

    public int cost;
}
