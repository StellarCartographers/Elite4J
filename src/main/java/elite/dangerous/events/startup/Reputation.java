/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.startup;

import elite.dangerous.base.Event;
import elite.dangerous.models.toreadable.ReputationName;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Reputation.
 */
@SuperBuilder
@Jacksonized
public class Reputation extends Event 
{

    /**
     * The independent.
     */
    public Double empire, federation, alliance, independent;

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
