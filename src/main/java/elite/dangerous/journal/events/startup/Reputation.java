/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.startup;

import lombok.*;

import elite.dangerous.core.Event;
import elite.dangerous.model.toreadable.ReputationName;

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
