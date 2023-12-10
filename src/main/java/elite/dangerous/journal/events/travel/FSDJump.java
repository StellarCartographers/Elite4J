package elite.dangerous.journal.events.travel;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.Conflict;
import elite.dangerous.model.Faction;
import lombok.EliteObject;

@EliteObject
public class FSDJump extends Event
{

    private String         starSystem;

    private String         systemAllegiance;

    private String         systemEconomy;

    private String         systemSecondEconomy;

    private String         systemGovernment;

    private String         systemSecurity;

    private String         body;

    private String         bodyType;

    public Faction         systemFaction;

    private String         powerplayState;

    private long           population;

    private long           systemAddress;

    private long           boostUsed;

    private int            bodyId;

    private double         jumpDistance;

    private double         fuelUsed;

    private double         fuelLevel;

    private List<Faction>  factions;

    private List<Conflict> conflicts;

    private double[]       starPos;

    private List<String>   powers;

}
