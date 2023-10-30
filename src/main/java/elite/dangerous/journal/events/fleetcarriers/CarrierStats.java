package elite.dangerous.journal.events.fleetcarriers;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.journal.models.CrewItem;
import elite.dangerous.journal.models.Finance;
import elite.dangerous.journal.models.Pack;
import elite.dangerous.journal.models.SpaceUsage;

public class CarrierStats extends Event
{

    public long carrierID;

    public String callsign;

    public String name;

    public String dockingAccess;

    public boolean allowNotorious;

    public int fuelLevel;

    public float jumpRangeCurr;

    public float jumpRangeMax;

    public boolean pendingDecommission;

    public SpaceUsage spaceUsage;

    public Finance finance;

    public List<CrewItem> crew;

    public List<Pack> shipPacks;

    public List<Pack> modulePacks;

}
