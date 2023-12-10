package elite.dangerous.journal.events.startup;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.toreadable.ReputationName;
import lombok.EliteObject;

@EliteObject
public class Reputation extends Event
{

    private double empire, federation, alliance, independent;

    public String getEmpireReputationReadable()
    {
        return ReputationName.getReadableName(this.empire);
    }

    public String getFederationReputationReadable()
    {
        return ReputationName.getReadableName(this.federation);
    }

    public String getAllianceReputationReadable()
    {
        return ReputationName.getReadableName(this.alliance);
    }

    public String getIndependentReputationReadable()
    {
        return ReputationName.getReadableName(independent);
    }
}
