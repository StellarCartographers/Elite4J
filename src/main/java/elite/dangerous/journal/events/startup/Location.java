package elite.dangerous.journal.events.startup;

import java.util.List;

import elite.dangerous.journal.Event;
import elite.dangerous.journal.models.Conflict;
import elite.dangerous.journal.models.Faction;
import elite.dangerous.journal.models.StationEconomy;

public class Location extends Event
{

    public String starSystem;

    public String systemAllegiance;

    public String systemEconomy;

    public String systemEconomyLocalised;

    public String systemSecondEconomy;

    public String systemSecondEconomyLocalised;

    public String systemGovernment;

    public String systemGovernmentLocalised;

    public String systemSecurity;

    public String systemSecurityLocalised;

    public String body;

    public String bodyType;

    public Faction systemFaction;

    public String powerplayState;

    public String stationName;

    public String stationType;

    public String stationEconomy;

    public Faction stationFaction;

    public String stationAllegiance;

    public String stationGovernment;

    public String stationEconomyLocalised;

    public String stationGovernmentLocalised;

    public double[] starPos;

    public long systemAddress, population, marketID;

    public int bodyID;

    public boolean docked;

    public List<Faction> factions;

    public List<Conflict> conflicts;

    public List<String> powers, stationServices;

    public List<StationEconomy> stationEconomies;

}
