/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.stationservices;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class CrewHire.
 */
@SuperBuilder
@Jacksonized
public class CrewHire extends Event 
{

    /**
     * The name.
     */
    public String  name;
    /**
     * The faction.
     */
    public String  faction;
    /**
     * The crew ID.
     */
    public Integer crewID;
    /**
     * The cost.
     */
    public Integer cost;
    /**
     * The combat rank.
     */
    public Integer combatRank;
}
