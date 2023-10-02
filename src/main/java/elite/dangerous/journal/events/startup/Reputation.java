package elite.dangerous.journal.events.startup;

import elite.dangerous.journal.Event;
import elite.dangerous.journal.models.toreadable.ReputationName;

public class Reputation extends Event
{

    public double empire, federation, alliance, independent;

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
