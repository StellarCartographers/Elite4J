package elite.dangerous.journal.models;

import java.util.List;

public class Faction
{

    public String name;

    public String factionState;

    public String government;

    public String allegiance;

    public String happiness;

    public double myReputation;

    public double influence;

    public List<FactionState> activeStates;

    public List<FactionState> pendingStates;

    public List<FactionState> recoveringStates;

    public boolean squadronSystem;

    public boolean happiestSystem;

    public boolean homeSystem;
}
