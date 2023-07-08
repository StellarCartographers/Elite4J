/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.exploration;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.station.Discovered;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class MultiSellExplorationData.
 */
@SuperBuilder
@Jacksonized
public class MultiSellExplorationData extends Event 
{

    /**
     * The discovered.
     */
    public List<Discovered> discovered;
    /**
     * The bonus.
     */
    public Integer          baseValue, totalEarnings, bonus;
}
