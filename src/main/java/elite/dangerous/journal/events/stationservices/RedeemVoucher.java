package elite.dangerous.journal.events.stationservices;

import java.util.List;

import elite.dangerous.journal.base.Event;

public class RedeemVoucher extends Event
{

    public String type;

    public long totalAmount;

    public int brokerPercentage;

    public List<FactionBounty> factions;

    public static class FactionBounty
    {

        public String faction;

        public long amount;
    }

}
