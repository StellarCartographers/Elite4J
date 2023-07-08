/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.combat;

import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class DiedByPVP.
 */
@SuperBuilder
@Jacksonized
public class DiedByPVP extends Died 
{

    /**
     * The killer name.
     */
    public String killerName;
    /**
     * The killer ship.
     */
    public String killerShip;
    /**
     * The killer rank.
     */
    public String killerRank;
}
