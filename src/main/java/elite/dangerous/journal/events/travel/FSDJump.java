package elite.dangerous.journal.events.travel;

import java.util.List;

import elite.dangerous.journal.Event;
import elite.dangerous.journal.models.Conflict;
import elite.dangerous.journal.models.Faction;

public class FSDJump extends Event
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

    public long population;

    public long systemAddress;

    public long boostUsed;

    public int bodyId;

    public double jumpDistance;

    public double fuelUsed;

    public double fuelLevel;

    public List<Faction> factions;

    public List<Conflict> conflicts;

    public double[] starPos;

    public List<String> powers;

}
