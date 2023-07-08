/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.exploration;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class SellExplorationData.
 */
@SuperBuilder
@Jacksonized
public class SellExplorationData extends Event 
{

    /**
     * The discovered.
     */
    public String[] systems, discovered;
    /**
     * The total earnings.
     */
    public Integer  baseValue, bonus, totalEarnings;
}
