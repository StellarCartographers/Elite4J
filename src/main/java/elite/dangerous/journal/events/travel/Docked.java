package elite.dangerous.journal.events.travel;

import java.util.List;

import elite.dangerous.journal.Event;
import elite.dangerous.journal.models.Faction;
import elite.dangerous.journal.models.StationEconomy;

public class Docked extends Event
{

    public String stationName;

    public String stationType;

    public String starSystem;

    public Faction stationFaction;

    public String stationGovernment;

    public String stationGovernmentLocalised;

    public String stationAllegiance;

    public String stationEconomy;

    public String stationEconomyLocalised;

    public List<StationEconomy> stationEconomies;

    public long systemAddress;

    public long marketID;

    public double distFromStarLS;

    public boolean cockpitBreach;

    public List<String> stationServices;

    public boolean activeFine;

    public boolean wanted;

    public boolean taxi;

    public boolean multicrew;

}
