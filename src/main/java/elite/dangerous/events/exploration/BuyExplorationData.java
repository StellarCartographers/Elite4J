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
 * The Class BuyExplorationData.
 */
@SuperBuilder
@Jacksonized
public class BuyExplorationData extends Event 
{

    /**
     * The system.
     */
    public String  system;
    /**
     * The cost.
     */
    public Integer cost;
}
