/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.combat;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Interdiction.
 */
@SuperBuilder
@Jacksonized
public class Interdiction extends Event 
{

    /**
     * The is player.
     */
    public Boolean success, isPlayer;
    /**
     * The power.
     */
    public String  interdicted, faction, power;
    /**
     * The combat rank.
     */
    public Integer combatRank;
}
