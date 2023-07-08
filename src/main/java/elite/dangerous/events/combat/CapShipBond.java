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
 * The Class CapShipBond.
 */
@SuperBuilder
@Jacksonized
public class CapShipBond extends Event 
{

    /**
     * The victim faction.
     */
    public String  victimFaction;
    /**
     * The awarding faction.
     */
    public String  awardingFaction;
    /**
     * The reward.
     */
    public Integer reward;
}
