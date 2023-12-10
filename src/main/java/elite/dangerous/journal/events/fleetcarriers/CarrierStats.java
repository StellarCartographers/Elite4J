package elite.dangerous.journal.events.fleetcarriers;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.CrewItem;
import elite.dangerous.model.Finance;
import elite.dangerous.model.Pack;
import elite.dangerous.model.SpaceUsage;
import lombok.EliteObject;

@EliteObject
public class CarrierStats extends Event
{

    private long           carrierID;

    private String         callsign;

    private String         name;

    private String         dockingAccess;

    private boolean        allowNotorious;

    private int            fuelLevel;

    public float           jumpRangeCurr;

    public float           jumpRangeMax;

    private boolean        pendingDecommission;

    public SpaceUsage      spaceUsage;

    public Finance         finance;

    private List<CrewItem> crew;

    private List<Pack>     shipPacks;

    private List<Pack>     modulePacks;

}
