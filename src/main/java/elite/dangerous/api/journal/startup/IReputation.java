/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.startup;

import elite.dangerous.model.toreadable.ReputationName;

public interface IReputation
{
    public double empire();

    public double federation();

    public double alliance();

    public double independent();

    public default String getEmpireReputationReadable()
    {
        return ReputationName.getReadableName(empire());
    }

    public default String getFederationReputationReadable()
    {
        return ReputationName.getReadableName(federation());
    }

    public default String getAllianceReputationReadable()
    {
        return ReputationName.getReadableName(alliance());
    }

    public default String getIndependentReputationReadable()
    {
        return ReputationName.getReadableName(independent());
    }
}
