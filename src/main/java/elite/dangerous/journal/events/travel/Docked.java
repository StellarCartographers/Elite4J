package elite.dangerous.journal.events.travel;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.Faction;
import elite.dangerous.model.StationEconomy;
import lombok.EliteObject;

@EliteObject
public class Docked extends Event
{

    private String               stationName;

    private String               stationType;

    private String               starSystem;

    public Faction               stationFaction;

    private String               stationGovernment;

    private String               stationAllegiance;

    private String               stationEconomy;

    private List<StationEconomy> stationEconomies;

    private long                 systemAddress;

    private long                 marketID;

    private double               distFromStarLS;

    private boolean              cockpitBreach;

    private List<String>         stationServices;

    private boolean              activeFine;

    private boolean              wanted;

    private boolean              taxi;

    private boolean              multicrew;

}
