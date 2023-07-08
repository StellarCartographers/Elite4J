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
 * The Class FactionKillBond.
 */
@SuperBuilder
@Jacksonized
public class FactionKillBond extends Event 
{

    /**
     * The reward.
     */
    public Integer reward;
    /**
     * The awarding faction.
     */
    public String  awardingFaction;
    /**
     * The victim faction.
     */
    public String  victimFaction;
}
