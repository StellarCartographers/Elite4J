/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.other;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class RepairDone.
 */
@SuperBuilder
@Jacksonized
public class RepairDone extends Event 
{

    /**
     * The hull repaired.
     */
    public Double hullRepaired;
    /**
     * The cockpit repaired.
     */
    public Double cockpitRepaired;
    /**
     * The corrosion repaired.
     */
    public Double corrosionRepaired;
}
