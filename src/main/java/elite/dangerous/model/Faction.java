package elite.dangerous.model;

import java.util.List;

import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public class Faction
{
    private String             name;
    private String             factionState;
    private String             government;
    private String             allegiance;
    private String             happiness;
    private double             myReputation;
    private double             influence;
    private List<FactionState> activeStates;
    private List<FactionState> pendingStates;
    private List<FactionState> recoveringStates;
    private boolean            squadronSystem;
    private boolean            happiestSystem;
    private boolean            homeSystem;
}
