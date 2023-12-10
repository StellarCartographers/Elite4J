package elite.dangerous.journal.events.startup;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.Conflict;
import elite.dangerous.model.Faction;
import elite.dangerous.model.StationEconomy;
import lombok.EliteObject;

@EliteObject
public class Location extends Event
{

    private String               starSystem;

    private String               systemAllegiance;

    private String               systemEconomy;

    private String               systemSecondEconomy;

    private String               systemGovernment;

    private String               systemSecurity;

    private String               body;

    private String               bodyType;

    public Faction               systemFaction;

    private String               powerplayState;

    private String               stationName;

    private String               stationType;

    private String               stationEconomy;

    public Faction               stationFaction;

    private String               stationAllegiance;

    private String               stationGovernment;

    private double[]             starPos;

    private long                 systemAddress, population, marketID;

    private int                  bodyID;

    private boolean              docked;

    private List<Faction>        factions;

    private List<Conflict>       conflicts;

    private List<String>         powers, stationServices;

    private List<StationEconomy> stationEconomies;

}
