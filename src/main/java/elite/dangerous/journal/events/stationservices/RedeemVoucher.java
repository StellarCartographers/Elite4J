package elite.dangerous.journal.events.stationservices;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.FactionBounty;
import lombok.EliteObject;

@EliteObject
public class RedeemVoucher extends Event
{
    private String              type;

    private long                totalAmount;

    private int                 brokerPercentage;

    private List<FactionBounty> factions;
}
